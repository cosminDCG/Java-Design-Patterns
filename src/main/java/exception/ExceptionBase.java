package exception;

import java.text.MessageFormat;

public class ExceptionBase extends Exception {

    private final int code;

    public ExceptionBase(String errorMessage, int code, Object... messageArgs) {
        super(f(errorMessage, messageArgs));
        this.code = code;
    }

    public static String f(String message, Object... messageArgs) {
        return MessageFormat.format(message, messageArgs);
    }

    public int getCode() {
        return code;
    }
}
