package Service;

import Model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ClientServiceTest {

    private ClientService service;

    @Before
    public void setUp() {
        service = new ClientService();
        service.addClient(1,"Name With abbb","address");
        service.addClient(2,"Name without that string","addr");
        service.addClient(3,"Another name with abbb","addr");
    }

    @Test
    public void filterByName() {
        assertEquals(2, StreamSupport.stream(service.filterByName("abb").spliterator(),false).count());
    }
}