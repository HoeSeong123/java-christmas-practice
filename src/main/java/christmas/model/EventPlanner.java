package christmas.model;

import static christmas.model.Event.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.model.Event.SPECIAL_DISCOUNT;
import static christmas.model.Event.WEEKDAY_DISCOUNT;
import static christmas.model.Event.WEEKEND_DISCOUNT;

import christmas.repository.EventRepository;
import java.time.LocalDate;
import java.util.List;

public class EventPlanner {
    public static void findEvents(int visitDate, OrderMenus orderMenus) {
        checkChristmasEvent(visitDate);
        checkWeekdayEvent(visitDate, orderMenus);
        checkWeekendEvent(visitDate, orderMenus);
        checkSpecialEvent(visitDate);
    }

    private static void checkChristmasEvent(int visitDate) {
        if (visitDate <= 25) {
            EventRepository.addEvent(CHRISTMAS_D_DAY_DISCOUNT, 1000 + 100 * (visitDate - 1));
        }
    }

    private static void checkWeekdayEvent(int visitDate, OrderMenus orderMenus) {
        if (!CalenderChecker.isWeekend(LocalDate.of(2023, 12, visitDate))) {
            EventRepository.addEvent(WEEKDAY_DISCOUNT, orderMenus.calculateWeekdayEvent());
        }
    }

    private static void checkWeekendEvent(int visitDate, OrderMenus orderMenus) {
        if (CalenderChecker.isWeekend(LocalDate.of(2023, 12, visitDate))) {
            EventRepository.addEvent(WEEKEND_DISCOUNT, orderMenus.calculateWeekendEvent());
        }
    }

    private static void checkSpecialEvent(int visitDate) {
        List<Integer> specialDate = List.of(3, 10, 17, 24, 25, 31);
        if (specialDate.contains(visitDate)) {
            EventRepository.addEvent(SPECIAL_DISCOUNT, 1000);
        }
    }
}
