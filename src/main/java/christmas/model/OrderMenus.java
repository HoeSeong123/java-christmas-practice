package christmas.model;

import static christmas.util.message.ExceptionMessage.INVALID_MENU;
import static christmas.util.message.ExceptionMessage.INVALID_ONLY_BEVERAGE;

import java.util.Map;

public class OrderMenus {
    private Map<String, Integer> orderMenus;

    public OrderMenus(Map<String, Integer> orderMenus) {
        validate(orderMenus);
        this.orderMenus = orderMenus;
    }

    private void validate(Map<String, Integer> orderMenus) {
        validateOnlyBeverage(orderMenus);
        for (String menu : orderMenus.keySet()) {
            validateValidMenu(menu);
        }
    }

    private void validateOnlyBeverage(Map<String, Integer> orderMenus) {
        if (Category.areOnlyBeverage(orderMenus.keySet())) {
            throw new IllegalArgumentException(INVALID_ONLY_BEVERAGE.get());
        }
    }

    private void validateValidMenu(String menu) {
        if (!Menu.containMenu(menu)) {
            throw new IllegalArgumentException(INVALID_MENU.get());
        }
    }
}
