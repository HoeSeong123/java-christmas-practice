package christmas.util.validator;

import static christmas.util.message.ExceptionMessage.INVALID_DUPLICATE_MENU;
import static christmas.util.message.ExceptionMessage.INVALID_ORDER_MENU_FORM;
import static christmas.util.message.GlobalMessage.COMMA;

import christmas.util.formatter.Formatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class OrderMenusValidator {
    public static void validate(String input) {
        Validator.validateNull(input);
        Validator.validateDuplicateSubstring(COMMA.get(), input);
        Validator.validateEndSubstring(COMMA.get(), input);
        Validator.validateStartSubstring(COMMA.get(), input);
        List<String> splitByDelimiter = Arrays.stream(input.split(COMMA.get())).toList();
        validateForms(splitByDelimiter);
        validateDuplicate(input, splitByDelimiter);
    }

    private static void validateForms(List<String> input) {
        for (String form : input) {
            validateForm(form);
        }
    }

    private static void validateForm(String input) {
        Pattern pattern = Pattern.compile("([가-힣]+)-(\\d+)");
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_ORDER_MENU_FORM.get());
        }
    }

    private static void validateDuplicate(String input, List<String> splitByDelimiter) {
        Map<String, Integer> menus = Formatter.formatOrderMenus(input);

        if (splitByDelimiter.size() != menus.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_MENU.get());
        }

    }
}

