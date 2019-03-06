package Validation;

import Exceptions.ValidatorException;

public interface IValidator<T> {
    void validate(T obj) throws ValidatorException;
}
