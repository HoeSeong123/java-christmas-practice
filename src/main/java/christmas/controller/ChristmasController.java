package christmas.controller;

import static christmas.util.RetryUtil.read;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
    public void run() {
        OutputView.printStartMessage();
        int visitDate = read(InputView::readVisitDate);
        Map<String, Integer> orderMenus = read(InputView::readOrderMenus);
    }
}
