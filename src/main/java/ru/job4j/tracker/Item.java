package ru.job4j.tracker;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

import static java.time.LocalDateTime.*;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime created = now();

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + formatter.format(created) +
                '}';
    }

    @Override
    public int compareTo(Item secondItem) {
        return Integer.compare(this.id, secondItem.id);
    }
}