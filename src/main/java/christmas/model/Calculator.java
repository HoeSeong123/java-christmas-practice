package christmas.model;

import static christmas.model.Event.PROMOTION_EVENT;

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

    public static int calculateAfterDiscountAmount(int totalPrice, Map<Event, Integer> appliedEvents) {
        totalPrice -= calculateTotalBenefitAmount(appliedEvents);
        if (appliedEvents.containsKey(PROMOTION_EVENT)) {
            totalPrice += 25_000;
        }

        return totalPrice;
    }
}
