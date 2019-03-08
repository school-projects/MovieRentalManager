package Console;

import Exceptions.UserInputException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Utility class for converting user input to native types
 *
 */
public class InputConverter {
    /**
     * Converts a String to an Integer
      * @param s the String
     * @return an Integer
     * @throws UserInputException if the String can't be converted
     */
    static public Integer readInt(String s) throws UserInputException{
        try{
            return Integer.valueOf(s);
        }
        catch(NumberFormatException e){
            throw new UserInputException("Integer is not properly formatted!");
        }
    }
    /**
     * Converts a String to an LocalDate
     * @param s the String
     * @return an LocalDate
     * @throws UserInputException if the String can't be converted
     */
    static public LocalDate readDate(String s) throws UserInputException{
        try{
            return LocalDate.parse(s);
        }
        catch(DateTimeParseException e){
            throw new UserInputException("Date is not properly formatted!");
        }
    }
}
