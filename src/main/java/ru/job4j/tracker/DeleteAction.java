package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "===Delete===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        boolean complete = tracker.delete(itemId);
        if (complete) {
            System.out.println("The item has been delete");
        } else {
            System.out.println("The item not found.");
        }
        return true;
    }
}
