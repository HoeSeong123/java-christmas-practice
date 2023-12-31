package christmas.view;

import static christmas.util.message.GlobalMessage.NEW_LINE;

import christmas.model.Event;
import christmas.model.OrderMenus;
import java.util.Map;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printOrderMenus(OrderMenus orderMenus) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println(NEW_LINE.get() + "<주문 메뉴>");
        for (String name : orderMenus.getOrderMenus().keySet()) {
            System.out.println(name + " " + orderMenus.getOrderMenus().get(name) + "개");
        }
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println(NEW_LINE.get() + "<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", totalPrice));
    }

    public static void printEvents(Map<Event, Integer> appliedEvents) {
        System.out.println(NEW_LINE.get() + "<증정 메뉴>");
        System.out.println(printPromotionEvent(appliedEvents));

        System.out.println(NEW_LINE.get() + "<혜택 내역>");
        System.out.println(printAppliedEvents(appliedEvents));
    }

    private static String printPromotionEvent(Map<Event, Integer> appliedEvents) {
        if (appliedEvents.containsKey(Event.PROMOTION_EVENT)) {
            return "샴페인 1개";
        }

        return "없음";
    }

    private static String printAppliedEvents(Map<Event, Integer> appliedEvents) {
        if (appliedEvents.isEmpty()) {
            return "없음";
        }
        StringBuilder sb = new StringBuilder();
        for (Event event : appliedEvents.keySet()) {
            sb.append(String.format("%s: -%,d원", event.getName(), appliedEvents.get(event)) + NEW_LINE.get());
        }

        return sb.toString();
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원" + NEW_LINE.get(), totalBenefitAmount);
    }

    public static void printAfterDiscountAmount(int afterDiscountAmount) {
        System.out.println(NEW_LINE.get() + "<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", afterDiscountAmount));
    }

    public static void printEventBadge(String badge) {
        System.out.println(NEW_LINE.get() + "<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
