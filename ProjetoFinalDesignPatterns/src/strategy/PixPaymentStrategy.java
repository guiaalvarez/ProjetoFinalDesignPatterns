package strategy;

public class PixPaymentStrategy implements PaymentStrategy {
    private String pixKey;

    public PixPaymentStrategy(String pixKey) {
        this.pixKey = pixKey;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with Pix key " + pixKey);
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95;
    }
}
