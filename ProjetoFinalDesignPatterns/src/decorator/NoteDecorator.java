package decorator;

import model.Order;

public class NoteDecorator extends OrderDecorator {
    private String note;

    public NoteDecorator(Order decoratedOrder, String note) {
        super(decoratedOrder);
        this.note = note;
    }


    @Override
    public double getTotalCost() {
        return decoratedOrder.getTotalCost();
    }
    @Override
    public String getNote() {
        return note;
    }
}
