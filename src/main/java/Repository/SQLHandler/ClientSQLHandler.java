package Repository.SQLHandler;

import Model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Stream;

public class ClientSQLHandler implements SQLHandler<Integer, Client> {

    private static final String table = "Client";

    @Override
    public String loadAll() {
        return "SELECT * " +
                "FROM " + table;
    }

    @Override
    public String insert(Client obj) {
        return "INSERT INTO " + table + "(ID, Name, Address) " +
                "VALUES(" + obj.getId().toString() + ", '" + obj.getName() + "', '" + obj.getAdress() +"')";
    }

    @Override
    public String delete(Integer id) {
        return "DELETE FROM " + table +
                " WHERE ID=" + id.toString();
    }

    @Override
    public String update(Client obj) {
        return "UPDATE " + table +
                " SET Name='" + obj.getName() + "', Address='" + obj.getAdress()+
                "' WHERE ID=" + obj.getId().toString();
    }

    @Override
    public Stream<Client> fromResultSet(ResultSet rs) throws SQLException {
        LinkedList<Client> ret = new LinkedList<>();
        while(rs.next()){
            ret.add(new Client(rs.getInt("ID"), rs.getString("Name"), rs.getString("Address")));
        }
        return ret.stream();
    }
}
