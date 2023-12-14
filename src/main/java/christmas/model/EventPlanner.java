package christmas.model;

import static christmas.model.Event.CHRISTMAS_D_DAY_DISCOUNT;

import christmas.repository.EventRepository;

public class EventPlanner {
    public static void findEvents(int visitDate, OrderMenus orderMenus) {
        checkChristmasEvent(visitDate);
    }

    private static void checkChristmasEvent(int visitDate) {
        if (visitDate <= 25) {
            EventRepository.addEvent(CHRISTMAS_D_DAY_DISCOUNT, 1000 + 100 * (visitDate - 1));
        }
    }
}
