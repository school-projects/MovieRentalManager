package Validation;

import Model.Movie;
import Exception.ValidatorException;

public class MovieValidator implements IValidator<Movie> {

    @Override
    public void validate(Movie mv) throws ValidatorException {
        String str ="";
        if (mv.getId()==null)
            str+="Invalid id! ";
        if(mv.getName().length()==0 || mv.getName().equals(""))
            str+="Invalid movie name! ";
        if(mv.getDate().length()==0 || mv.getDate().equals(""))
            str+="Invalid movie date! ";

        if(!str.equals(""))
            throw new ValidatorException(str);
    }
}
