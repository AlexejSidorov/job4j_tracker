package ru.job4j.tracker;

public class FindById implements UserAction{

    private Output out;

    public FindById(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "Find By Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Find By Id===");
        int itemId = input.askInt("Enter id of target item:");
        Item foundItem = tracker.findById(itemId);
        if (foundItem == null) {
            out.println("The item not found");
        } else {
            out.println(foundItem);
        }
        return true;
    }
}
