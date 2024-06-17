package model;

import strategy.PaymentStrategy;

import java.util.Date;
import java.util.List;

public class Order {
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private Date date;
    private PaymentStrategy paymentStrategy;

    public Order(User user, Restaurant restaurant, List<MenuItem> items, Date date) {
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Date getDate() {
        return date;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public String getNote() {
        return "";
    }
}
