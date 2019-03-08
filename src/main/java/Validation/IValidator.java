package Validation;

import Exceptions.ValidatorException;

/**
 * Interface for a validator class
 * @param <T> the object that the class validates
 */
public interface IValidator<T> {
    /**
     * Validates the given object
     * @param obj object to be validated
     * @throws ValidatorException if the object is not valid
     */
    void validate(T obj) throws ValidatorException;
}
