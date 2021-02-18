package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Delete===");
        int itemId = input.askInt("Enter id of target item:");
        boolean complete = tracker.delete(itemId);
        if (complete) {
            out.println("The item has been delete");
        } else {
            out.println("The item not found.");
        }
        return true;
    }
}
