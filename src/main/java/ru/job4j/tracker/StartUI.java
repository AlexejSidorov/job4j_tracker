package ru.job4j.tracker;

public class StartUI {

    private static void createItem(Input input, Tracker tracker) {
        String name = input.askStr("=== Create a new Item ===="
                + System.lineSeparator()
                + "Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Done");
        System.out.println(item);
    }

    private static void showAllItems(Input input, Tracker tracker) {
        Item[] foundItems = tracker.findAll();
        if (foundItems.length == 0) {
            System.out.println("The tracker is empty.");
        } else {
            for (Item item : foundItems) {
                System.out.println(item);
            }
        }
    }

    private static void editItem(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        String newItemName = input.askStr("Enter new item name:");
        boolean complete = tracker.replace(itemId, new Item(newItemName));
        if (complete) {
            System.out.println("The item has been changed");
        } else {
            System.out.println("The item not found.");
        }
    }

    private static void deleteItem(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        boolean complete = tracker.delete(itemId);
        if (complete) {
            System.out.println("The item has been delete");
        } else {
            System.out.println("The item not found.");
        }
    }

    private static void findItemById(Input input, Tracker tracker) {
        int itemId = input.askInt("Enter id of target item:");
        Item foundItem = tracker.findById(itemId);
        if (foundItem == null) {
            System.out.println("The item not found");
        } else {
            System.out.println(foundItem);
        }
    }

    private static void findItemByName(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter name of target item:");
        Item[] foundItems = tracker.findByName(itemName);
        if (foundItems.length == 0) {
            System.out.println("Item/items not found");
        } else {
            for (Item foundItem : foundItems) {
                System.out.println(foundItem);
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(input, tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit Program" + System.lineSeparator()
                + "Select:");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
