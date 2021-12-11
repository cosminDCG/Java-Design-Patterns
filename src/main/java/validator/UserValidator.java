package validator;

import exception.BadCnpException;
import exception.ExceptionBase;
import exception.MinLengthException;
import pojo.User;

public class UserValidator extends ValidatorBase<User> {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String NICK_NAME = "nickName";

    @Override
    public void validate(User user) throws ExceptionBase {
        enforceMinLength(user.getFirstName(), FIRST_NAME);
        enforceMinLength(user.getLastName(), LAST_NAME);
        enforceMinLength(user.getNickName(), NICK_NAME);
        enforceCnpLength(user.getCnp());
    }

    private void enforceCnpLength(String cnp) throws BadCnpException {
        if (cnp.length() != 13) {
            throw new BadCnpException("The cnp {0} is wrong! The length must be 13!", 1, cnp);
        }
    }

    private void enforceMinLength(String field, String fieldName) throws MinLengthException {
        if (field != null && field.length() < 3) {
            throw new MinLengthException("The value {0} for the field {1} is too short! It should be minimum 3!", 2, field, fieldName);
        }
    }
}
