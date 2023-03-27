package Behaviors;

import Others.VisitorOntology;
import Others.OrderStatus;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.util.Objects;

public class FinishOrder extends Behaviour {

    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            if (Objects.equals(msg.getOntology(), VisitorOntology.ONTOLOGY_NAME)) {
                try {
                    OrderStatus orderStatus = (OrderStatus) msg.getContentObject();
                    System.out.println("Получил сообщение " + orderStatus.localName() +
                            " от стола " + orderStatus.cellId() +
                            ": " + orderStatus.menu());
                    myAgent.doDelete();
                } catch (UnreadableException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}