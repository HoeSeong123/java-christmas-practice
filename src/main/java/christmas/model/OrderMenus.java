package christmas.model;

import static christmas.util.message.ExceptionMessage.INVALID_MENU;
import static christmas.util.message.ExceptionMessage.INVALID_ONLY_BEVERAGE;
import static christmas.util.message.ExceptionMessage.INVALID_ORDER_COUNT;
import static christmas.util.message.ExceptionMessage.INVALID_ZERO_ORDER;

import java.util.Collections;
import java.util.Map;

public class OrderMenus {
    private Map<String, Integer> orderMenus;

    public OrderMenus(Map<String, Integer> orderMenus) {
        validate(orderMenus);
        this.orderMenus = orderMenus;
    }

    public Map<String, Integer> getOrderMenus() {
        return Collections.unmodifiableMap(orderMenus);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (String menu : orderMenus.keySet()) {
            total += Menu.getPriceByName(menu) * orderMenus.get(menu);
        }

        return total;
    }

    private void validate(Map<String, Integer> orderMenus) {
        for (String menu : orderMenus.keySet()) {
            validateValidMenu(menu);
        }
        validateOnlyBeverage(orderMenus);
        validateTotalCount(orderMenus);
        validateZeroOrder(orderMenus);
    }

    private void validateOnlyBeverage(Map<String, Integer> orderMenus) {
        if (Category.areOnlyBeverage(orderMenus.keySet())) {
            throw new IllegalArgumentException(INVALID_ONLY_BEVERAGE.get());
        }
    }

    private void validateTotalCount(Map<String, Integer> orderMenus) {
        int totalSum = orderMenus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalSum > 20) {
            throw new IllegalArgumentException(INVALID_ORDER_COUNT.get());
        }
    }

    private void validateZeroOrder(Map<String, Integer> orderMenus) {
        boolean containsZero = orderMenus.values().stream()
                .anyMatch(value -> value.equals(0));

        if (containsZero) {
            throw new IllegalArgumentException(INVALID_ZERO_ORDER.get());
        }
    }

    private void validateValidMenu(String menu) {
        if (!Menu.containMenu(menu)) {
            throw new IllegalArgumentException(INVALID_MENU.get());
        }
    }

    public int calculateWeekdayEvent() {
        return orderMenus.entrySet().stream()
                .filter(entry -> Category.isDessertMenu(entry.getKey()))
                .mapToInt(entry -> entry.getValue() * 2023)
                .sum();
    }

    public int calculateWeekendEvent() {
        return orderMenus.entrySet().stream()
                .filter(entry -> Category.isMainMenu(entry.getKey()))
                .mapToInt(entry -> entry.getValue() * 2023)
                .sum();
    }
}
