package strategy;

public interface PaymentStrategy {
    void pay(double amount);
    double applyDiscount(double amount);
}
