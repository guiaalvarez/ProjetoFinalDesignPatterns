package strategy;

public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with credit card " + cardNumber);
    }

    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}
