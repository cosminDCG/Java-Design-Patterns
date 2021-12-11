package validator;

import exception.ExceptionBase;

public abstract class ValidatorBase<T> {

    public abstract void validate(T entity) throws ExceptionBase;
}
