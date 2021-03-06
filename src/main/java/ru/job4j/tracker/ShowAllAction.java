package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Show All Items===");
        List<Item> foundItems = tracker.findAll();
        if (foundItems.size() == 0) {
            out.println("The tracker is empty.");
        } else {
            for (Item item : foundItems) {
                out.println(item);
            }
        }
        return true;
    }
}
