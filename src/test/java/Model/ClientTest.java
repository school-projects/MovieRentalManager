package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    private Client a;
    @Before
    public void setUp() {
        a= new Client(1,"gigel","no");
    }

    @Test
    public void getName() {
        assertEquals("gigel",a.getName());
    }

    @Test
    public void getAdress() {
        assertEquals("no",a.getAdress());
    }

    @Test
    public void setName() {
        a.setName("agigel");
        assertEquals("agigel",a.getName());
    }

    @Test
    public void setAddress() {
        a.setAddress("ano");
        assertEquals("ano",a.getAdress());
    }
}