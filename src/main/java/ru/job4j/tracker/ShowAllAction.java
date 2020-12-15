package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private Output out;

    public ShowAllAction(Output out){
        this.out = out;
    }
    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Show All Items===");
        Item[] foundItems = tracker.findAll();
        if (foundItems.length == 0) {
            System.out.println("The tracker is empty.");
        } else {
            for (Item item : foundItems) {
                System.out.println(item);
            }
        }
        return true;
    }
}
