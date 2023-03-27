package Behaviors;

import Agents.SupervisorAgent;
import Agents.ManagerAgent;
import AgentObjects.Equipment;
import AgentObjects.MenuItem;
import Others.Message;
import AgentObjects.Operation;
import AgentObjects.Order;
import AgentObjects.Recipe;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class MakeMeal extends Behaviour {

    @Override
    public void action() {
        if (!ManagerAgent.orders.isEmpty()) {
            Order order = ManagerAgent.orders.peek();
            for (MenuItem menuItem : SupervisorAgent.menu.getMenu()) {
                if (menuItem.getId() == order.getDishId()) {
                    for (Recipe recipe : SupervisorAgent.recipes.getRecipes()) {
                        if (recipe.getId() == menuItem.getRecipeId()) {
                            for (Operation operation : recipe.getProcess().getMakingProcess()) {
                                for (Equipment equipment : SupervisorAgent.equipment.getEquipment()) {
                                    if (equipment.getEquipmentType_id() == operation.getEquipType()) {
                                        equipment.setActive(false);
                                        myAgent.doWait((long) (operation.getTime() * 1000));
                                        equipment.setActive(true);
                                        ManagerAgent.orders.poll();
                                        break;
                                    }
                                }
                            }
                            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                            msg.addReceiver(new AID("Order" + ManagerAgent.map.get(order.getId()), AID.ISLOCALNAME));
                            try {
                                var message = new Message(myAgent.getLocalName());
                                msg.setContentObject(message);
                                myAgent.send(msg);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}