package christmas.util.validator;

import static christmas.util.message.ExceptionMessage.INVALID_IS_NULL;
import static christmas.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;
import static christmas.util.message.ExceptionMessage.INVALID_OUT_OF_INT_RANGE;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private Validator() {
    }

    public static void validateNumber(String input) {
        validateIsNumeric(input);
        validateRange(input);
    }

    public static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_IS_NULL.get());
        }
    }

    private static void validateIsNumeric(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.get());
        }
    }

    private static void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_OUT_OF_INT_RANGE.get());
        }
    }

    public static void validateDuplicateSubstring(String substring, String value, String target) {
        if (containsDuplicateSubstring(substring, value)) {
            throw new IllegalArgumentException(String.format("%s에 구분자는 하나만 입력해주세요", target));
        }
    }

    public static void validateStartSubstring(String substring, String value, String target) {
        if (value.startsWith(substring)) {
            throw new IllegalArgumentException(String.format("%s은(는) 구분자로 시작할 수 없습니다.", target));
        }
    }

    public static void validateEndSubstring(String substring, String value, String target) {
        if (value.endsWith(substring)) {
            throw new IllegalArgumentException(String.format("%s은(는) 구분자로 끝날 수 없습니다.", target));
        }
    }

    private static boolean containsDuplicateSubstring(String substring, String value) {
        String doubleSubstring = substring.repeat(2);
        return value.contains(doubleSubstring);
    }
}
