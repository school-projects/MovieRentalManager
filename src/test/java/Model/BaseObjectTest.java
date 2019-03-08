package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseObjectTest {
    private BaseObject<Integer> b;

    @Before
    public void setUp(){
        b = new BaseObject<>(1);
    }

    @Test
    public void getId() {
        assertEquals(Integer.valueOf(1), b.getId());
    }

    @Test
    public void setId() {
        b.setId(2);
        assertEquals(Integer.valueOf(2), b.getId());
    }
}