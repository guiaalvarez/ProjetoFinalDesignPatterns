package chain;

import model.Order;

public abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Order order) {
        process(order);
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }

    protected abstract void process(Order order);
}
