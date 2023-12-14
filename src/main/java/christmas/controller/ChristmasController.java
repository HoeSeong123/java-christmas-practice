package christmas.controller;

import static christmas.util.RetryUtil.read;

import christmas.model.Calculator;
import christmas.model.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
    public void run() {
        OutputView.printStartMessage();
        int visitDate = read(InputView::readVisitDate);
        OrderMenus orderMenus = read(this::readOrderMenus);
        OutputView.printOrderMenus(orderMenus);
        int totalPrice = Calculator.calculateTotalPrice(orderMenus);
        OutputView.printTotalPrice(totalPrice);

    }

    private OrderMenus readOrderMenus() {
        Map<String, Integer> orderMenus = read(InputView::readOrderMenus);
        return new OrderMenus(orderMenus);
    }
}
