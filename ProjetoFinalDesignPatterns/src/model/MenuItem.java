package model;

public class MenuItem {
    private final String name;
    private final double price;
    private final String description;
    private final boolean vegetarian;
    private final boolean glutenFree;

    public MenuItem(String name, double price, String description, boolean vegetarian, boolean glutenFree) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.vegetarian = vegetarian;
        this.glutenFree = glutenFree;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", glutenFree=" + glutenFree +
                '}';
    }
}
