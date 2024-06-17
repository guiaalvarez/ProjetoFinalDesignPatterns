package chain;

import model.Order;
import strategy.PaymentStrategy;

public class ProcessPaymentHandler extends Handler {
    @Override
    protected void process(Order order) {
        PaymentStrategy paymentStrategy = order.getPaymentStrategy();
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment failed: No payment method supplied.");
        }

        double totalAmount = order.getTotalCost();
        totalAmount = paymentStrategy.applyDiscount(totalAmount);
        try {
            paymentStrategy.pay(totalAmount);
            System.out.println("Payment successful.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
