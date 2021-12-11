package exception;

public class MinLengthException extends ExceptionBase {
    public MinLengthException(String errorMessage, int code, Object... messageArgs) {
        super(errorMessage, code, messageArgs);
    }
}
