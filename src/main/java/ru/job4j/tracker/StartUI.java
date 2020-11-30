package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Tool");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String itemDateFormat = item.getCreated().format(formatter);
        System.out.println("Item was created: " + itemDateFormat);
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item foundItem = tracker.findById(1);
        if (foundItem != null) {
            System.out.println(System.lineSeparator()
                    + foundItem.getId()
                    + System.lineSeparator()
                    + foundItem.getName()
                    + System.lineSeparator()
                    + foundItem.getCreated().format(formatter));

        }
        System.out.println(item.toString());
    }
}
