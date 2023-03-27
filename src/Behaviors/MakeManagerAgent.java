package Behaviors;

import Agents.SupervisorAgent;
import Agents.ManagerAgent;
import jade.core.behaviours.OneShotBehaviour;

public class MakeManagerAgent extends OneShotBehaviour {
    @Override
    public void action() {
        ((SupervisorAgent) myAgent).addAgent("Manager", ManagerAgent.class.getName());
    }
}