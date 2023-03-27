package Behaviors;

import Agents.ManagerAgent;
import Others.VisitorOrder;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AcceptOrder extends Behaviour {
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            try {
                VisitorOrder visitorOrder = (VisitorOrder) msg.getContentObject();
                System.out.println("Заказ от " + visitorOrder.getLocalName() + ": " + visitorOrder.getMenu());
                ((ManagerAgent)myAgent).setCurrentMenu(visitorOrder.getMenu());
                ((ManagerAgent)myAgent).setCurrentCustomerName(visitorOrder.getLocalName());
                ManagerAgent.orders.addAll(visitorOrder.getMenu());
                myAgent.addBehaviour(new CreateOrder(visitorOrder.getMenu()));
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}