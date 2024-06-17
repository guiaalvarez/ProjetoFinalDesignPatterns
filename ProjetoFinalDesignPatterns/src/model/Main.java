package model;

import singleton.Configuration;
import decorator.NoteDecorator;
import decorator.TipDecorator;
import notification.NotificationFactory;
import notification.NotificationService;
import strategy.CreditCardStrategy;
import strategy.PixPaymentStrategy;
import strategy.PaymentStrategy;
import chain.Handler;
import chain.ProcessPaymentHandler;
import chain.ValidateAvailabilityHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    /*
    private static Handler getChainOfHandlers() {
        Handler validateAvailabilityHandler = new ValidateAvailabilityHandler(Handler.AVAILABILITY);
        Handler processPaymentHandler = new ProcessPaymentHandler(Handler.PAYMENT);

        validateAvailabilityHandler.setNextHandler(processPaymentHandler);

        return validateAvailabilityHandler;
    }*/

    public static void main(String[] args) {

        Configuration config = Configuration.getInstance();
        System.out.println("Database URL: " + config.getSetting("dbUrl"));
        System.out.println("Currency: " + config.getSetting("currency"));

        User user = new User("Guilherme", "guilhermeaalvarez@gmail.com", "61981568726");

        Restaurant designPizzas = new Restaurant("Design Pizzas");

        MenuItem calabresaDesign = designPizzas.createMenuItem("Calabresa", 60, "Cheese, tomato sauce, calabresa", false, false);
        MenuItem cocaDesign = designPizzas.createMenuItem("Coca-cola", 10, "300ml", true, true);


        List<MenuItem> items = new ArrayList<>();
        items.add(calabresaDesign);
        items.add(cocaDesign);
        // items.add(steak);
        Order order = new Order(user, designPizzas, items, new Date());


        Order orderWithTip = new TipDecorator(order, 5.00);
        Order orderWithNote = new NoteDecorator(orderWithTip, "Extra cheese, please.");

        //Payment
        orderWithNote.setPaymentStrategy(new PixPaymentStrategy("user_pix_key"));

        //Notification
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(NotificationFactory.createNotification("EMAIL", user.getEmail()));
        notificationService.addObserver(NotificationFactory.createNotification("PHONE NUMBER", user.getPhoneNumber()));

        //Chain
        Handler validateAvailabilityHandler = new ValidateAvailabilityHandler();
        Handler processPaymentHandler = new ProcessPaymentHandler();
        validateAvailabilityHandler.setNextHandler(processPaymentHandler);

        try {
            validateAvailabilityHandler.handle(orderWithNote);
            // Send notification if the order is successful
            notificationService.update("Your order has been successfully and it's being prepared");
            notificationService.update("The delivery dude has left the restaurant");
            System.out.println("Order for " + user.getName() + " with: " +orderWithNote.getNote() + " processed successfully.");
        } catch (IllegalStateException e) {
            System.err.println("Order processing failed: " + e.getMessage());
        }
    }
}