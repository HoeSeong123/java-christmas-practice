package christmas.controller;

import static christmas.util.RetryUtil.read;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public void run() {
        OutputView.printStartMessage();
        int visitDate = read(InputView::readVisitDate);
    }
}
