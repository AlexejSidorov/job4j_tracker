package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Done");
                System.out.println(item);
            } else if (select == 1) {
                Item[] foundItems = tracker.findAll();
                if (foundItems.length == 0) {
                    System.out.println("The tracker is empty.");
                } else {
                    for (Item item : foundItems) {
                        System.out.println(item);
                    }
                }
            } else if (select == 2) {
                System.out.println("Enter id of target item:");
                int itemId = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new item name:");
                String newItemName = scanner.nextLine();
                boolean complete = tracker.replace(itemId, new Item(newItemName));
                if (complete) {
                    System.out.println("The item has been changed");
                } else {
                    System.out.println("The item not found.");
                }
            } else if (select == 3) {
                System.out.println("Enter id of target item:");
                int itemId = Integer.valueOf(scanner.nextLine());
                boolean complete = tracker.delete(itemId);
                if (complete) {
                    System.out.println("The item has been delete");
                } else {
                    System.out.println("The item not found.");
                }
            } else if (select == 4) {
                System.out.println("Enter id of target item:");
                int itemId = Integer.valueOf(scanner.nextLine());
                Item foundItem = tracker.findById(itemId);
                if (foundItem == null) {
                    System.out.println("The item not found");
                } else {
                    System.out.println(foundItem);
                }
            } else if (select == 5) {
                System.out.println("Enter name of target item:");
                String itemName = scanner.nextLine();
                Item[] foundItems = tracker.findByName(itemName);
                if (foundItems.length == 0) {
                    System.out.println("Item/items not found");
                } else {
                    for (Item foundItem : foundItems) {
                        System.out.println(foundItem);
                    }
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
