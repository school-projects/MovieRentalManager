package Console;

import Exceptions.UserInputException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class InputConverterTest {

    @Test
    public void readInt() {
        assertEquals(Integer.valueOf(2),InputConverter.readInt("2"));
    }

    @Test(expected = UserInputException.class)
    public void readIntExc(){
        InputConverter.readInt("z");
    }

    @Test
    public void readDate() {
        assertEquals(LocalDate.parse("1920-02-02"),InputConverter.readDate("1920-02-02"));
    }

    @Test(expected = UserInputException.class)
    public void readDateExc(){
        InputConverter.readDate("Date man bad");
    }
}