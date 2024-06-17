package decorator;

import model.Order;

public abstract class OrderDecorator extends Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        super(decoratedOrder.getUser(), decoratedOrder.getRestaurant(), decoratedOrder.getItems(), decoratedOrder.getDate());
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double getTotalCost() {
        return decoratedOrder.getTotalCost();
    }
}
