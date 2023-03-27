package Behaviors;

import Agents.CustomerAgent;
import Others.VisitorOrder;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class StartOrder extends OneShotBehaviour {
    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Manager", AID.ISLOCALNAME));
        try {
            var customerMessage = new VisitorOrder(myAgent.getLocalName(), ((CustomerAgent) myAgent).menu);
            msg.setContentObject(customerMessage);
            myAgent.send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}