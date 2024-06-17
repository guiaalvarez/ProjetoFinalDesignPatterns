package notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Observer {
    private List<Notification> notifications = new ArrayList<>();

    public void addObserver(Notification notification) {
        notifications.add(notification);
    }

    @Override
    public void update(String message) {
        for (Notification notification : notifications) {
            notification.send(message);
        }
    }
}
