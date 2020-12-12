package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "===Find By Name===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter name of target item:");
        Item[] foundItems = tracker.findByName(itemName);
        if (foundItems.length == 0) {
            System.out.println("Item/items not found");
        } else {
            for (Item foundItem : foundItems) {
                System.out.println(foundItem);
            }
        }
        return true;
    }
}
