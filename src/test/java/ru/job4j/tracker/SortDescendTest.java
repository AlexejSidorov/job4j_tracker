package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDescendTest {

    @Test
    public void isSortAscend() {
        List<Item> items = Arrays.asList(
                new Item(2, "2"),
                new Item(4, "4"),
                new Item(3, "3"),
                new Item(5, "5")
        );
        Collections.sort(items, new SortAscend());
        List<String> expectedNames = Arrays.asList("2", "3", "4", "5");
        List<String> itemsNames = new ArrayList<>();
        for(Item item : items){
            itemsNames.add(item.getName());
        }
        Assert.assertEquals(expectedNames, itemsNames);
    }

    @Test
    public void isSortDescend() {
        List<Item> items = Arrays.asList(
                new Item(2, "2"),
                new Item(4, "4"),
                new Item(3, "3"),
                new Item(5, "5")
        );
        Collections.sort(items, new SortDescend());
        List<String> expectedNames = Arrays.asList("5", "4", "3", "2");
        List<String> itemsNames = new ArrayList<>();
        for(Item item : items){
            itemsNames.add(item.getName());
        }
        Assert.assertEquals(expectedNames, itemsNames);
    }
}