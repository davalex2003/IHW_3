package Agents;

import Behaviors.FinishOrder;
import Behaviors.StartOrder;
import AgentObjects.Order;
import jade.core.Agent;
import java.util.HashSet;

public class CustomerAgent extends Agent {

    public HashSet<Order> menu;

    protected void setup() {
        Object[] args = getArguments();
        menu = (HashSet<Order>) args[0];
        System.out.println("Агент " + getAID().getLocalName() + " запустился");
        addBehaviour(new StartOrder());
        addBehaviour(new FinishOrder());
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getLocalName() + " закончил");
        super.takeDown();
    }


}
