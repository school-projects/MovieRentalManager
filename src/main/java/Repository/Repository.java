package Repository;

import Model.BaseObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import Exceptions.RepositoryException;

/**
 * In-Memory Repository that implements the IRepository<TYPE,T extends BaseObject<TYPE>> interface
 *
 * @param <TYPE> the TYPE of the id
 * @param <T>    the type of the object that uses a TYPE-type id
 */
public class Repository<TYPE, T extends BaseObject<TYPE>> implements IRepository<TYPE, T> {
    private Map<TYPE, T> elements;

    public Repository() {
        this.elements = new HashMap<>();
    }

    public Optional<T> add(T elem) {
        if (elem == null)
            throw new RepositoryException("invalid add! item is null!");
        return Optional.ofNullable(elements.putIfAbsent(elem.getId(), elem));
    }

    public Optional<T> delete(TYPE id) {
        if (id == null)
            throw new RepositoryException("invalid delete! id is null!");
        return Optional.ofNullable(elements.remove(id));
    }

    public Optional<T> update(T elem) {
        if (elem == null)
            throw new RepositoryException("invalid update! item is null!");
        return Optional.ofNullable(elements.computeIfPresent(elem.getId(), (k, v) -> elem));
    }

    public Optional<T> find(TYPE id) {
        if (id == null)
            throw new RepositoryException("invalid find! id is null!");
//        if (!elements.containsKey(id))
//            throw new RepositoryException("no such object in the repository!");
        return Optional.ofNullable(elements.get(id));
    }

    public Iterable<T> findAll() {
        return elements.values();
    }
}
