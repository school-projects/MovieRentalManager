package Repository;

import Model.BaseObject;
import Model.Movie;
import Validation.IValidator;
import Validation.MovieValidator;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class RepositoryTest {

    private Repository<Integer, Movie> repo;
    private Movie q;

    @Before
    public void setUp() {
        IValidator val = new MovieValidator();
        repo = new Repository<Integer, Movie>(val);
        Movie m = new Movie(1, "Cool Movie Name1", LocalDate.parse("2000-02-21"));
        Movie n = new Movie(2, "Cool Movie Name2", LocalDate.parse("2000-02-22"));
        Movie p = new Movie(3, "Cool Movie Name3", LocalDate.parse("2000-02-23"));
        Movie r = new Movie(4, "Cool Movie Name4", LocalDate.parse("2000-02-24"));
        q = new Movie(5,"Cool Movie Name5", LocalDate.parse("2000-02-25"));
        repo.add(m);repo.add(n);repo.add(p);repo.add(r);
    }

    @Test
    public void add() {
        repo.add(q);
        assertEquals(5,repo.getElements().size());
    }

    @Test
    public void delete() {
        repo.delete(4);
        assertEquals(3,repo.getElements().size());
    }

    @Test
    public void update() {
        Movie v = new Movie(4,"a",LocalDate.parse("1999-01-01"));
        repo.update(v);
        assertTrue(repo.find(4).isPresent());
        assertEquals("a",repo.find(4).get().getName());
    }

    @Test
    public void find() {
        assertTrue(repo.find(4).isPresent());
        assertEquals("Cool Movie Name4",repo.find(4).get().getName());
    }

    @Test
    public void findAll() {
        assertEquals(4,repo.findAll().spliterator().getExactSizeIfKnown());
    }
}