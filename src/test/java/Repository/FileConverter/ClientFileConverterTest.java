package Repository.FileConverter;

import Model.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientFileConverterTest {

    private Client cli;
    private ClientFileConverter con;

    @Before
    public void setUp(){
        cli = new Client(1, "Name Name", "Addr");
        con =  new ClientFileConverter();
    }

    @Test
    public void totString() {
        assertEquals("1,Name Name,Addr",con.toString(cli));
    }

    @Test
    public void fromString() {
        Client cli1 = con.fromString("1,Name Name,Addr");
        assertEquals(Integer.valueOf(1), cli1.getId());
        assertEquals("Name Name",cli1.getName());
        assertEquals("Addr", cli1.getAdress());
    }
}