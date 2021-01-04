package ru.job4j.tracker;

public class TrackerSingleFinalEager {

    private static final Tracker TRACKER = new Tracker();

    private TrackerSingleFinalEager() {
    }

    public static Tracker getTracker(){
        return TRACKER;
    }
}
