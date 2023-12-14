package christmas.util.message;

public enum ExceptionMessage {

    INVALID_IS_NULL("공백은 입력할 수 없습니다."),
    INVALID_NOT_NUMERIC("숫자만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    INVALID_VISIT_DATE_RANGE("방문 날짜는 1 ~ 31 사이의 숫자만 입력 가능합니다."),
    INVALID_ORDER_MENU_FORM("유효하지 않은 입력 형식입니다."),
    INVALID_MENU("존재하지 않는 메뉴입니다."),
    INVALID_DUPLICATE_MENU("중복된 메뉴는 입력할 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String get() {
        return message;
    }
}