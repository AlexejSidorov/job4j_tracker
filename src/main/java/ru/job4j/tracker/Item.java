package ru.job4j.tracker;

import java.time.*;
import java.util.Objects;

import static java.time.LocalDateTime.*;

public class Item {
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
}