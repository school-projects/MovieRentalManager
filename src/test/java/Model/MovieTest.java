package Model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie m;

    @Before
    public void setUp() {
        m = new Movie(1,"Cool Movie Name", LocalDate.parse("2000-02-20"));
    }

    @Test
    public void getName() {
        assertEquals("Cool Movie Name",m.getName());
    }

    @Test
    public void setName() {
        m.setName("Uncool Movie Name");
        assertEquals("Uncool Movie Name", m.getName());
    }

    @Test
    public void getDate() {
        assertEquals(LocalDate.parse("2000-02-20"), m.getDate());
    }

    @Test
    public void setDate() {
        m.setDate(LocalDate.parse("2002-02-20"));
        assertEquals(LocalDate.parse("2002-02-20"), m.getDate());
    }
}