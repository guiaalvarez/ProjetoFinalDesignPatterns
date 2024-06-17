package decorator;

import model.Order;

public class TipDecorator extends OrderDecorator {
    private double tip;

    public TipDecorator(Order decoratedOrder, double tip) {
        super(decoratedOrder);
        this.tip = tip;
    }

    @Override
    public double getTotalCost() {
        return super.getTotalCost() + tip;
    }
}
