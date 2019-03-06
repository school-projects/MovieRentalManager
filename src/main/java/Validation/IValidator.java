package Validation;

import Exception.ValidatorException;

public interface IValidator<T> {
    void validate(T obj) throws ValidatorException;
}
