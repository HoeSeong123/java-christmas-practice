package christmas.model;

import static christmas.util.message.ExceptionMessage.INVALID_MENU;

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
    }

    private void validateValidMenu(String menu) {
        if (!Menu.containMenu(menu)) {
            throw new IllegalArgumentException(INVALID_MENU.get());
        }
    }
}
