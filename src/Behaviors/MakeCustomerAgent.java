package Behaviors;

import Agents.SupervisorAgent;
import Agents.CustomerAgent;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.util.HashSet;

public class MakeCustomerAgent extends TickerBehaviour {
    int customerId = 0;

    public MakeCustomerAgent(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        if (customerId < ((SupervisorAgent) myAgent).customers.getCustomers().size()) {
            ((SupervisorAgent) myAgent).addAgent("Посетитель " + ((SupervisorAgent) myAgent).customers.getCustomers().get(customerId).getName(),
                    CustomerAgent.class.getName(), "Customer-Container", new HashSet[]{((SupervisorAgent) myAgent).customers.getCustomers().get(customerId++).getOrder()});
        }
    }
}