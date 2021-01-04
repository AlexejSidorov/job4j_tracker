package ru.job4j.tracker;

public class TrackerSingleFinalLazy {

    private TrackerSingleFinalLazy() {
    }

    public static Tracker getTracker() {
        return Holder.TRACKER;
    }

    private static final class Holder {
        private static final Tracker TRACKER = new Tracker();
    }
}
