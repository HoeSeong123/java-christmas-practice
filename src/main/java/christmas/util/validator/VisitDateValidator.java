package christmas.util.validator;

import static christmas.util.message.ExceptionMessage.INVALID_VISIT_DATE_RANGE;

public class VisitDateValidator {
    public static void validate(String input) {
        Validator.validateNull(input);
        Validator.validateNumber(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(INVALID_VISIT_DATE_RANGE.get());
        }
    }
}
