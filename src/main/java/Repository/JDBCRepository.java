package Repository;

import Exceptions.FileException;
import Model.BaseObject;
import Repository.Paging.IPage;
import Repository.Paging.IPageable;
import Repository.Paging.Paginator;
import Repository.Paging.PagingRepository;
import Repository.SQLHandler.SQLHandler;
import Validation.IValidator;

import java.io.Serializable;
import java.sql.*;
import java.util.Optional;
import java.util.stream.Collectors;

public class JDBCRepository<ID extends Serializable, T extends BaseObject<ID>> extends Repository<ID,T> implements PagingRepository<ID, T>{
    private Paginator<T> paginator;
    private SQLHandler<ID, T> gen;

    private static final String USER = "postgres";
    private static final String PASS = "pizza";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/pizza";

    public JDBCRepository(IValidator<T> val, Paginator<T> paginator, SQLHandler<ID,T> gen) {
        super(val);
        this.paginator = paginator;
        this.gen = gen;
        load();
    }

    private void load(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conn.createStatement()){
            stmt.execute(gen.loadAll());
            elements = gen.fromResultSet(stmt.getResultSet()).collect(Collectors.toMap(T::getId, it->it));
        }catch(SQLException e){
            throw new FileException("Couldn't open Database for loading!");
        }
    }

    @Override
    public IPage<T> findAll(IPageable pageable) {
        return paginator.page(elements.values().stream(), pageable);
    }

    @Override
    public Optional<T> add(T elem) {
        Optional<T> ret = super.add(elem);
        if(!ret.isPresent())
            try(Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conn.createStatement()){
                stmt.execute(gen.insert(elem));
            }
            catch(SQLException e){
                throw new FileException("Couldn't add element to Database, changes will not be saved!");
            }
        return ret;
    }

    @Override
    public Optional<T> delete(ID id) {
        Optional<T> ret = super.delete(id);
        if(ret.isPresent())
            try(Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conn.createStatement()){
                stmt.execute(gen.delete(id));
            }catch(SQLException e){
                throw new FileException("Couldn't remove element from Database, changes will not be saved!");
            }
        return ret;
    }

    @Override
    public Optional<T> update(T elem) {
        Optional<T> ret = super.update(elem);
        if(ret.isPresent())
            try(Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conn.createStatement()){
                System.out.println(gen.update(elem));
                stmt.execute(gen.update(elem));
            }
            catch(SQLException e){
                throw new FileException("Couldn't update element in the Database, changes will not be saved!");
            }
        return ret;
    }
}
