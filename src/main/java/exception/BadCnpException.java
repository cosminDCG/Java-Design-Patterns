package exception;

public class BadCnpException extends ExceptionBase {

  public BadCnpException(String errorMessage, int code, Object... messageArgs) {
    super(errorMessage, code, messageArgs);
  }
}
