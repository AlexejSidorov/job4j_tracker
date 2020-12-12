package ru.job4j.tracker;

public class FindById implements UserAction{
    @Override
    public String name() {
        return "===Find By Id===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        Item foundItem = tracker.findById(itemId);
        if (foundItem == null) {
            System.out.println("The item not found");
        } else {
            System.out.println(foundItem);
        }
        return true;
    }
}
