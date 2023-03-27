package Behaviors;

import Agents.OrderAgent;
import Others.VisitorOntology;
import Others.OrderStatus;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Finish extends OneShotBehaviour {
    @Override
    public void action() {
        System.out.println(myAgent.getLocalName() + " отправил сообщение " + ((OrderAgent)myAgent).getCustomerName());
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(((OrderAgent)myAgent).getCustomerName(), AID.ISLOCALNAME));
        try {
            var messageFromOrder = new OrderStatus(
                    myAgent.getLocalName(),
                    ((OrderAgent)myAgent).getMenu(),
                    ((OrderAgent)myAgent).getCellId());
            VisitorOntology visitorOntology = VisitorOntology.getInstance();
            msg.setContentObject(messageFromOrder);
            msg.setOntology(visitorOntology.getName());
            myAgent.send(msg);
            myAgent.doDelete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
