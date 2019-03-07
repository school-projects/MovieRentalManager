package Validation;

import Model.Movie;
import Exceptions.ValidatorException;

public class MovieValidator implements IValidator<Movie> {

    @Override
    public void validate(Movie mv) throws ValidatorException {
        Integer movieId = mv.getId();
        String movieName = mv.getName();
        String movieDate = mv.getDate();

        String exceptionStr = "";
        if (movieId == null)
            exceptionStr += "Invalid id! ";
        if (movieName.length() == 0 || movieName.trim().length() == 0)
            exceptionStr += "Invalid movie name! ";
        if (movieDate.length() == 0)
            exceptionStr += "Invalid movie date! ";

        if (!exceptionStr.equals(""))
            throw new ValidatorException(exceptionStr);
    }
}
