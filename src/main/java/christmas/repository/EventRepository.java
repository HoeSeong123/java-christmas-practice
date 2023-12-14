package christmas.repository;

import christmas.model.Event;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static final Map<Event, Integer> appliedEvents = new HashMap<>();

    public static void addEvent(Event event, Integer amount) {
        appliedEvents.put(event, amount);
    }
}
