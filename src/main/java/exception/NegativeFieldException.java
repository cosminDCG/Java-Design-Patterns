package exception;

public class NegativeFieldException extends ExceptionBase {

    public NegativeFieldException(String errorMessage, int code, Object... messageArgs) {
        super(errorMessage, code, messageArgs);
    }
}
