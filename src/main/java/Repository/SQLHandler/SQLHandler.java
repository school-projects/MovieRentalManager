package Repository.SQLHandler;

import Model.BaseObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public interface SQLHandler<ID, T extends BaseObject<ID>> {
    String findAll();
    String insert(T obj);
    String delete(ID id);
    String update(T obj);
    String find(ID id);
    Stream<T> fromResultSet(ResultSet rs) throws SQLException;
}
