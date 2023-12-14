package christmas.model;

import java.util.Map;

public class Calculator {
    public static int calculateTotalPrice(OrderMenus orderMenus) {
        return orderMenus.calculateTotalPrice();
    }

    public static int calculateTotalBenefitAmount(Map<Event, Integer> appliedEvents) {
        int total = 0;
        for (Event event : appliedEvents.keySet()) {
            total += appliedEvents.get(event);
        }

        return total;
    }
}
