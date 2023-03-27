package Behaviors;

import jade.core.behaviours.OneShotBehaviour;

public class StockIngredients extends OneShotBehaviour {

    String customerName;
    @Override
    public void action() {
    }

    public StockIngredients(String customerName) {
        this.customerName = customerName;
    }
}
