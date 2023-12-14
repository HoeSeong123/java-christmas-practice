package christmas.view.formatter;

import static christmas.util.message.GlobalMessage.COMMA;
import static christmas.util.message.GlobalMessage.HYPHEN;

import java.util.HashMap;
import java.util.Map;

public class InputFormatter {
    public static Map<String, Integer> formatOrderMenus(String input) {
        Map<String, Integer> orderMenus = new HashMap<>();
        String[] splitByComma = input.split(COMMA.get());

        for (String order : splitByComma) {
            String[] orderDetail = order.split(HYPHEN.get());
            orderMenus.put(orderDetail[0], Integer.parseInt(orderDetail[1]));
        }

        return orderMenus;
    }
}
