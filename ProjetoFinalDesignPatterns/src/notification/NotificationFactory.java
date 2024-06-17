package notification;

public class NotificationFactory {
    public static Notification createNotification(String type, String contact) {
        if (type.equals("EMAIL")) {
            return new EmailNotification(contact);
        }
        if (type.equals("PHONE NUMBER")) {
            return new PhoneNotification(contact);
        } else {
            throw new IllegalArgumentException("Unknown notification type.");
        }
    }
}
