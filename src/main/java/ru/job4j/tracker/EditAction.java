package ru.job4j.tracker;

public class EditAction implements UserAction{


    @Override
    public String name() {
        return "===Edit===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        String newItemName = input.askStr("Enter new item name:");
        boolean complete = tracker.replace(itemId, new Item(newItemName));
        if (complete) {
            System.out.println("The item has been changed");
        } else {
            System.out.println("The item not found.");
        }
        return true;
    }
}
