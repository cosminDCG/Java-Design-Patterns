package exception;

public class InvalidPriceException extends ExceptionBase {

    public InvalidPriceException(String errorMessage, int code, Object... messageArgs) {
        super(errorMessage, code, messageArgs);
    }
}
