package Repository;
//repository interface for storing T-type elements
public interface IRepository<T> {
    void add(T elem);
    void delete(T elem);
}
