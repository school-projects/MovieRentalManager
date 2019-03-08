package Validation;

import Model.Movie;
import Exceptions.ValidatorException;

import java.time.LocalDate;

/**
 * Validator for the movie class
 */
public class MovieValidator implements IValidator<Movie> {

    /**
     * Validates a given movie
     * @param mv movie to be validated
     * @throws ValidatorException if the id is null
     *                            if the name is empty
     *                            if the date is not between 1900 and 2100
     */
    @Override
    public void validate(Movie mv) throws ValidatorException {
        Integer movieId = mv.getId();
        String movieName = mv.getName();
        LocalDate movieDate = mv.getDate();

        String exceptionStr = "";
        if (movieId == null)
            exceptionStr += "Invalid id! ";
        if (movieName.length() == 0 || movieName.trim().length() == 0)
            exceptionStr += "Invalid movie name! ";

        // Release date should be between 1900 and 2100
        if (movieDate.isBefore(LocalDate.of(1900, 1, 1)) ||
                movieDate.isAfter(LocalDate.of(2100, 12, 31)))
            exceptionStr += "Invalid movie date! ";

        if (!exceptionStr.equals(""))
            throw new ValidatorException(exceptionStr);
    }
}
