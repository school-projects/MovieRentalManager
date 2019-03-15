package Repository.FileConverter;

import Model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MovieFileConverterTest {

    private Movie mov;
    private MovieFileConverter con;

    @Before
    public void setUp(){
        mov = new Movie(1,"Name Name", LocalDate.parse("2000-02-02"));
        con = new MovieFileConverter();
    }

    @Test
    public void totString() {
        assertEquals("1,Name Name,2000-02-02", con.toString(mov));
    }

    @Test
    public void fromString() {
        Movie mov1 = con.fromString("1,Name Name,2000-02-02");
        assertEquals(mov.getId(),mov1.getId());
        assertEquals(mov.getName(), mov1.getName());
        assertEquals(mov.getDate(), mov1.getDate());
    }
}