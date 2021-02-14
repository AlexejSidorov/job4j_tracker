package ru.job4j.tracker;

import java.util.List;

public class FindByName implements UserAction {

    private Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find By Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Find By Name===");
        String itemName = input.askStr("Enter name of target item:");
        List<Item> foundItems = tracker.findByName(itemName);
        if (foundItems.size() == 0) {
            out.println("Item/items not found");
        } else {
            for (Item foundItem : foundItems) {
                out.println(foundItem);
            }
        }
        return true;
    }
}
