package christmas.view;

import static christmas.util.message.GlobalMessage.NEW_LINE;

import christmas.model.OrderMenus;

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
}
