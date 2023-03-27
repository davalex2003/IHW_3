package Behaviors;

import Agents.ManagerAgent;
import Agents.OrderAgent;
import AgentObjects.Order;
import jade.core.behaviours.OneShotBehaviour;

import java.util.HashSet;

public class CreateOrder extends OneShotBehaviour {

    static int orderId = 1;

    HashSet<Order> menu;

    @Override
    public void action() {
        ((ManagerAgent) myAgent).addAgent("Order" + orderId,
                OrderAgent.class.getName(), "Order-Container", new Object[]{
                        ((ManagerAgent) myAgent).getCurrentMenu(),
                        ((ManagerAgent) myAgent).getCurrentCustomerName()
                });
        myAgent.addBehaviour(new StockIngredients(((ManagerAgent) myAgent).getCurrentCustomerName()));
        assert ManagerAgent.orders.peek() != null;
        ManagerAgent.map.put(ManagerAgent.orders.peek().getId(), orderId);
        ++orderId;
    }

    public CreateOrder(HashSet<Order> menu) {
        this.menu = menu;
    }
}