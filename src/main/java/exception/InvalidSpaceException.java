package exception;

public class InvalidSpaceException extends ExceptionBase {

    public InvalidSpaceException(String errorMessage, int code, Object... messageArgs) {
        super(errorMessage, code, messageArgs);
    }
}
