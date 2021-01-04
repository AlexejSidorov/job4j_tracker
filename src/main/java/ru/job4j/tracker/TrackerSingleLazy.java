package ru.job4j.tracker;

public class TrackerSingleLazy {

    private static Tracker tracker;

    private TrackerSingleLazy() {
    }

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }
}
