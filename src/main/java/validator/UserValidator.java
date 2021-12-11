package validator;

import exception.BadCnpException;
import exception.ExceptionBase;
import pojo.User;

public class UserValidator extends ValidatorBase<User> {

  @Override
  public void validate(User object) throws ExceptionBase {
    if (object.getLocation() != null) {

    }
    enforceCnpLength(object.getCnp());
  }

  private void enforceCnpLength(String cnp) throws BadCnpException {
    if (cnp.length() != 13) {
      throw new BadCnpException("The cnp {0} is wrong! The length must be 13!", 1, cnp);
    }
  }
}
