package Validation;

import Exceptions.ValidatorException;
import Model.Rental;

import java.util.Optional;

public class RentalValidator implements IValidator<Rental> {
    public void validate(Rental rental) throws ValidatorException {
        Optional<Rental> rentalOptional = Optional.of(rental);
        rentalOptional.filter(r -> r.getId() != null).orElseThrow(() -> new ValidatorException("Invalid rental ID!"));
        rentalOptional.filter(r -> r.getRentalEnd().isAfter(r.getRentalStart())).orElseThrow(() -> new ValidatorException("Rental start must be before rental end!"));
    }
}
