package Repository.SQLHandler;

import Model.Rental;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Stream;

public class RentalSQLHandler implements SQLHandler<Integer, Rental> {
   
    private static final String table = "Rental";

    @Override
    public String findAll() {
        return "SELECT * " +
                "FROM " + table;
    }

    @Override
    public String insert(Rental obj) {
        return "INSERT INTO " + table + "(ID, Cid, Mid, RentalStart, RentalEnd) " +
                "VALUES(" + obj.getId().toString() + ", " + obj.getClientId().toString() + ", " + obj.getMovieId() + ", '" +
                obj.getRentalStart().toString() + "', '" + obj.getRentalEnd().toString() +"')";
    }

    @Override
    public String delete(Integer id) {
        return "DELETE FROM " + table +
                "WHERE ID=" + id.toString();
    }

    @Override
    public String update(Rental obj) {
        return "UPDATE " + table +
                " SET CID=" + obj.getClientId().toString() + ", MID=" + obj.getMovieId() + ", RentalStart='" +
                obj.getRentalStart().toString() + "', RentalEnd= '" + obj.getRentalEnd().toString() +
                "' WHERE ID=" + obj.getId().toString();
    }

    @Override
    public String find(Integer integer) {
        return "SELECT * " +
                "FROM " + table+
                " WHERE ID=" + integer.toString();
    }

    @Override
    public Stream<Rental> fromResultSet(ResultSet rs) throws SQLException {
        LinkedList<Rental> ret = new LinkedList<>();
        while(rs.next()){
            ret.add(new Rental(rs.getInt("ID"), rs.getInt("CID"), rs.getInt("MID"),
                    LocalDate.parse(rs.getString("rentalstart")), LocalDate.parse(rs.getString("rentalend"))));
        }
        return ret.stream();
    }

}
