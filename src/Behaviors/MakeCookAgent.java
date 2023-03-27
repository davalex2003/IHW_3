package Behaviors;

import Agents.SupervisorAgent;
import Agents.CookAgent;
import jade.core.behaviours.OneShotBehaviour;

public class MakeCookAgent extends OneShotBehaviour {
    @Override
    public void action() {
        for (var cook :
                ((SupervisorAgent) myAgent).cooks.getCooks()) {
            ((SupervisorAgent) myAgent).addAgent("Повар" + cook.getCook_id(), CookAgent.class.getName(),
                    "Cook-Container", new Object[]{});
        }
    }
}