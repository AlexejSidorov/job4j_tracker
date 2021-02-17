package ru.job4j.tracker;

import java.util.Comparator;

public class SortAscend implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.compareTo(second);
    }
}
