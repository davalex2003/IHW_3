package Agents;

import Behaviors.IsReady;
import AgentObjects.Order;
import jade.core.Agent;
import java.util.HashSet;
import java.util.Random;

public class OrderAgent extends Agent {

    private String customerName;
    private int cellId = 0;
    private HashSet<Order> menu;

    protected void setup() {
        Object[] args = getArguments();
        menu = (HashSet<Order>) args[0];
        Random random = new Random();
        cellId = random.nextInt(1, 20);
        customerName = (String) args[1];
        System.out.println("Агент-менеджер создал " + this.getLocalName() + " агента.");
        addBehaviour(new IsReady());
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCellId() {
        return cellId;
    }


    public HashSet<Order> getMenu() {
        return menu;
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }


}
