package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] temp = new Item[size];
        int tempSize = 0;
        for (Item search : items) {
            if (search.getName().equals(key)) {
                temp[tempSize] = search;
                tempSize++;
            }
        }
        return Arrays.copyOf(temp, tempSize);
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, size);
    }
}