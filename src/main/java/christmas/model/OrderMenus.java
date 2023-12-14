package christmas.model;

import static christmas.util.message.ExceptionMessage.INVALID_MENU;
import static christmas.util.message.ExceptionMessage.INVALID_ONLY_BEVERAGE;
import static christmas.util.message.ExceptionMessage.INVALID_ORDER_COUNT;

import java.util.Map;

public class OrderMenus {
    private Map<String, Integer> orderMenus;

    public OrderMenus(Map<String, Integer> orderMenus) {
        validate(orderMenus);
        this.orderMenus = orderMenus;
    }

    private void validate(Map<String, Integer> orderMenus) {
        for (String menu : orderMenus.keySet()) {
            validateValidMenu(menu);
        }
        validateOnlyBeverage(orderMenus);
        validateCount(orderMenus);
    }

    private void validateOnlyBeverage(Map<String, Integer> orderMenus) {
        if (Category.areOnlyBeverage(orderMenus.keySet())) {
            throw new IllegalArgumentException(INVALID_ONLY_BEVERAGE.get());
        }
    }

    private void validateCount(Map<String, Integer> orderMenus) {
        int totalSum = orderMenus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalSum > 20) {
            throw new IllegalArgumentException(INVALID_ORDER_COUNT.get());
        }
    }

    private void validateValidMenu(String menu) {
        if (!Menu.containMenu(menu)) {
            throw new IllegalArgumentException(INVALID_MENU.get());
        }
    }
}
