package Repository;

import Model.BaseObject;

//repository interface for storing T-type elements
public interface IRepository<TYPE,T extends BaseObject<TYPE>> {
    void add(T elem);
    void delete(TYPE id);
    void update(T elem);
    T find(TYPE id);
    Iterable<T> findAll();
}
