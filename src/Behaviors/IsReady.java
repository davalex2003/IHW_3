package Behaviors;

import Others.Message;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class IsReady extends Behaviour {
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            try {
                Message message = (Message) msg.getContentObject();
                System.out.println("Получил сообщение " + message.localName());
                myAgent.addBehaviour(new Finish());
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