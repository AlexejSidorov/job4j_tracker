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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] temp = new Item[size];
        int tempSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                temp[tempSize] = items[i];
                tempSize++;
            }
        }
        return Arrays.copyOf(temp, tempSize);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (id < 0 || item == null) {
            return false;
        }
        int searchId = indexOf(id);
        if (searchId == -1) {
            return false;
        }
        item.setId(id);
        items[searchId] = item;
        return true;
    }

    public boolean delete(int id) {
        if (id < 0) {
            return false;
        }
        int delIndex = indexOf(id);
        if (delIndex == -1) {
            return false;
        }
        items[delIndex] = null;
        int startPos = delIndex + 1;
        int length = size - delIndex;
        System.arraycopy(items, startPos, items, delIndex, length);
        items[size - 1] = null;
        size--;
        return true;
    }
}