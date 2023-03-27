package Agents;

import Behaviors.MakeMeal;
import jade.core.Agent;

public class CookAgent extends Agent {
    protected void setup() {
        System.out.println("Агент " + getAID().getLocalName() + " запустился");
        addBehaviour(new MakeMeal());
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getLocalName() + " закончил");
        super.takeDown();
    }
}
