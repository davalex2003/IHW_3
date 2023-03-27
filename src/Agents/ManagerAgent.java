package Agents;

import Behaviors.AcceptOrder;
import JSON.Exception;
import JSON.Manager;
import AgentObjects.Order;
import jade.core.*;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class ManagerAgent extends Agent {

    public static HashMap<Integer, Integer> map = new HashMap<>();

    private HashSet<Order> currentMenu;

    public static Queue<Order> orders = new ArrayDeque<>();

    private String currentCustomerName;

    protected void setup() {
        System.out.println("Агент " + getAID().getLocalName() + " запустился");
        addBehaviour(new AcceptOrder());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
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
        } catch (StaleProxyException e) {
            String entity = name + ":" + className;
            Manager.writeFatalError(new Exception("StaleProxyException", "unable to start agent " + entity));
        }
    }

    public HashSet<Order> getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(HashSet<Order> currentMenu) {
        this.currentMenu = currentMenu;
    }

    public String getCurrentCustomerName() {
        return currentCustomerName;
    }

    public void setCurrentCustomerName(String currentCustomerName) {
        this.currentCustomerName = currentCustomerName;
    }
}
