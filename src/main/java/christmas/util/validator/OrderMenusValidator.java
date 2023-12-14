package christmas.util.validator;

import static christmas.util.message.GlobalMessage.COMMA;

public class OrderMenusValidator {
    public static void validate(String input) {
        Validator.validateNull(input);
        Validator.validateDuplicateSubstring(COMMA.get(), input);
        Validator.validateEndSubstring(COMMA.get(), input);
        Validator.validateStartSubstring(COMMA.get(), input);
    }
}
