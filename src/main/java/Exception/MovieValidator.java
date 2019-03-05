package Exception;

import Model.Movie;
import java.util.regex.*;
public class MovieValidator {
    public void validate(Movie mv){
        String str ="";
        if (mv.getId()==null)
            str+="Invalid id! ";
        if(mv.getMovie_name().length()==0 || mv.getMovie_name().equals(""))
            str+="Invalid movie name! ";
        if(mv.getRelease_date().length()==0 || mv.getRelease_date().equals(""))
            str+="Invalid movie date! ";
        if(!str.equals(""))
            throw new ValidatorException(str);
    }
}
