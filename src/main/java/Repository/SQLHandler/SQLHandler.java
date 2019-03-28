package Repository.SQLHandler;

import Model.BaseObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public interface SQLHandler<ID, T extends BaseObject<ID>> {
    String loadAll();
    String insert(T obj);
    String delete(ID id);
    String update(T obj);
    Stream<T> fromResultSet(ResultSet rs) throws SQLException;
}
