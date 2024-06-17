package chain;

import model.MenuItem;
import model.Order;
import model.Restaurant;

public class ValidateAvailabilityHandler extends Handler {
    @Override
    protected void process(Order order) {
        Restaurant restaurant = order.getRestaurant();
        for (MenuItem item : order.getItems()) {
            if (!restaurant.getMenu().contains(item)) {
                throw new IllegalStateException("Item " + item.getName() + " is not available.");
            }
        }
        System.out.println("All items are available.");
    }
}
