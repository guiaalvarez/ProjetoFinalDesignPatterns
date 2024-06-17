package factory;

import model.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class MenuItemFactory {
    private Map<String, MenuItem> menuItems;

    public MenuItemFactory() {
        this.menuItems = new HashMap<>();
    }

    public MenuItem createMenuItem(String name, double price, String description, boolean vegetarian, boolean glutenFree) {
        if (!menuItems.containsKey(name)) {
            MenuItem menuItem = new MenuItem(name, price, description, vegetarian, glutenFree);
            menuItems.put(name, menuItem);
        }
        return menuItems.get(name);
    }

    public MenuItem getMenuItem(String name) {
        return menuItems.get(name);
    }
}

