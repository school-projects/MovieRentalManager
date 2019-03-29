package Repository.SQLHandler;

import Model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Stream;

public class MovieSQLHandler implements SQLHandler<Integer, Movie> {

    private static final String table = "Movie";

    @Override
    public String findAll() {
        return "SELECT * " +
                "FROM " + table;
    }

    @Override
    public String insert(Movie obj) {
        return "INSERT INTO " + table + "(ID, Name, ReleaseDate) " +
                "VALUES(" + obj.getId().toString() + ", '" + obj.getName() + "', '" + obj.getDate().toString() +"')";
    }

    @Override
    public String delete(Integer id) {
        return "DELETE FROM " + table +
                " WHERE ID=" + id.toString();
    }

    @Override
    public String update(Movie obj) {
        return "UPDATE " + table +
                " SET Name='" + obj.getName() + "', ReleaseDate='" + obj.getDate().toString()+
                "' WHERE ID=" + obj.getId().toString();
    }

    @Override
    public String find(Integer integer) {
        return "SELECT * " +
                "FROM " + table+
                " WHERE ID=" + integer.toString();
    }

    @Override
    public Stream<Movie> fromResultSet(ResultSet rs) throws SQLException {
        LinkedList<Movie> ret = new LinkedList<>();
        while(rs.next()){
            ret.add(new Movie(rs.getInt("ID"), rs.getString("Name"), LocalDate.parse(rs.getString("ReleaseDate"))));
        }
        return ret.stream();
    }
}
