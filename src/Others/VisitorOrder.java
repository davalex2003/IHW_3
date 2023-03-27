package Others;

import AgentObjects.Order;
import jade.content.AgentAction;

import java.util.HashSet;

public class VisitorOrder implements AgentAction {

    private final String localName;

    private HashSet<Order> menu;

    public VisitorOrder(String localName, HashSet<Order> menu) {
        this.localName = localName;
        this.menu = menu;
    }

    public String getLocalName() {
        return localName;
    }

    public HashSet<Order> getMenu() {
        return menu;
    }

}
