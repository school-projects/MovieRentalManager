package Service;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService service;

    @Before
    public void setUp() {
        service = new MovieService();
        service.addMovie(1,"alo", LocalDate.parse("1990-02-02"));
        service.addMovie(2,"alo2", LocalDate.parse("1992-02-02"));
    }

    @Test
    public void filterByYear() {
        assertEquals(1, StreamSupport.stream(service.filterByYear(1990).spliterator(),false).count());

    }
}