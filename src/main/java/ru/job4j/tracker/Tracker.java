package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int searchId = indexOf(id);
        if (searchId == -1) {
            return false;
        }
        item.setId(id);
        items.set(searchId, item);
        return true;
    }

    public boolean delete(int id) {
        int delIndex = indexOf(id);
        if (delIndex == -1) {
            return false;
        }
        items.remove(delIndex);
        return true;
    }
}