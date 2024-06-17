package notification;

public class PhoneNotification implements Notification {
    private String phoneNumber;

    public PhoneNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending sms to " + phoneNumber + ": " + message);
    }
}
