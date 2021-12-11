package exception;

public class InvalidYearException extends ExceptionBase {

  public InvalidYearException(String errorMessage, int code, Object... messageArgs) {
    super(errorMessage, code, messageArgs);
  }
}
