package model;

import factory.MenuItemFactory;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private MenuItemFactory menuItemFactory;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.menuItemFactory = new MenuItemFactory();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public MenuItem createMenuItem(String name, double price, String description, boolean vegetarian, boolean glutenFree) {
        MenuItem menuItem = menuItemFactory.createMenuItem(name, price, description, vegetarian, glutenFree);
        addItem(menuItem);
        return menuItem;
    }
}
