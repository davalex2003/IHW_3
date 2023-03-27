package Others;

import AgentObjects.Order;
import jade.content.AgentAction;

import java.util.HashSet;

public record OrderStatus(String localName, HashSet<Order> menu, int cellId) implements AgentAction {
}
