package exception;

import java.text.MessageFormat;

public class ExceptionBase  extends Exception{
  private final int code;

  public ExceptionBase(String errorMessage, int code, Object... messageArgs) {
    super(MessageFormat.format(errorMessage, messageArgs));
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
