package Agents;

import Behaviors.MakeCookAgent;
import Behaviors.MakeCustomerAgent;
import Behaviors.MakeManagerAgent;
import Containers.Cookers;
import Containers.Equipments;
import Containers.EquipmentTypes;
import JSON.Exception;
import JSON.Manager;
import Containers.ProductTypes;
import AgentObjects.Menu;
import Containers.OperationTypes;
import AgentObjects.RecipeBook;
import Containers.Visitors;
import AgentObjects.Stock;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.Runtime;
import jade.core.*;
import jade.domain.FIPANames;
import jade.domain.JADEAgentManagement.CreateAgent;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;
import java.util.HashSet;

public class SupervisorAgent extends Agent {

    public static Menu menu;
    public static RecipeBook recipes;
    public static ProductTypes ingredientTypes;
    public Stock storage;
    public EquipmentTypes equipmentTypes;
    public static Equipments equipment;
    public Cookers cooks;
    public OperationTypes operationTypes;
    public Visitors customers;

    protected void setup() {
        System.out.println("Агент " + getAID().getLocalName() + " запустился");
        menu = new Menu(new HashSet<>(Manager.readFromFile("Resources/menu_dishes.txt", Menu.class).getMenu()));
        recipes = new RecipeBook(new HashSet<>(Manager.readFromFile("Resources/dish_cards.txt", RecipeBook.class).getRecipes()));
        ingredientTypes = new ProductTypes(new HashSet<>(Manager.readFromFile("Resources/product_types.txt", ProductTypes.class).getIngredientTypes()));
        storage = new Stock(new HashSet<>(Manager.readFromFile("Resources/products.txt", Stock.class).getStorage()));
        equipmentTypes = new EquipmentTypes(new HashSet<>(Manager.readFromFile("Resources/equipment_type.txt", EquipmentTypes.class).getEquipmentTypes()));
        equipment = new Equipments(new HashSet<>(Manager.readFromFile("Resources/equipment.txt", Equipments.class).getEquipment()));
        cooks = new Cookers(new HashSet<>(Manager.readFromFile("Resources/cookers.txt", Cookers.class).getCooks()));
        operationTypes = new OperationTypes(new HashSet<>(Manager.readFromFile("Resources/operation_types.txt", OperationTypes.class).getOperationTypes()));
        customers = new Visitors(new ArrayList<>(Manager.readFromFile("Resources/customers.txt", Visitors.class).getCustomers()));
        addBehaviour(new MakeCustomerAgent(this, 5000));
        addBehaviour(new MakeManagerAgent());
        addBehaviour(new MakeCookAgent());
    }

    public void addAgent(String name, String className, String containerName, Object[] args) {
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.CONTAINER_NAME, containerName);
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        ContainerController container = runtime.createAgentContainer(profile);
        try {
            AgentController agent = container.createNewAgent(name, className, args);
            agent.start();
            new AID(name, false);
        } catch (StaleProxyException e) {
            String entity = name + ":" + className;
            Manager.writeFatalError(new Exception("StaleProxyException", "Unable to start agent " + entity));
        }
    }

    public void addAgent(String name, String agent) {
        CreateAgent ca = new CreateAgent();
        ca.setAgentName(name);
        ca.setClassName(agent);
        ca.setContainer(new ContainerID("Main-Container", null));
        Action actExpr = new Action(getAMS(), ca);
        ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
        request.addReceiver(getAMS());
        request.setOntology(JADEManagementOntology.getInstance().getName());

        getContentManager().registerLanguage(new SLCodec(),
                FIPANames.ContentLanguage.FIPA_SL);

        getContentManager().registerOntology(JADEManagementOntology.getInstance());

        request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
        try {
            getContentManager().fillContent(request, actExpr);
            addBehaviour(new AchieveREInitiator(this, request) {
                protected void handleInform(ACLMessage inform) {
                }

                protected void handleFailure(ACLMessage failure) {
                    System.out.println("Exception occurred while creating agent");
                    Manager.writeException(new Exception("OntologyException",
                            "Exception occurred while creating agent"));
                }
            });
        } catch (OntologyException | Codec.CodecException ignored) {
        }
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }
}
