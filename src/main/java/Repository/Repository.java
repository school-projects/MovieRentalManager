package Repository;

import Model.BaseObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import Validation.IValidator;

/**
 * In-Memory Repository that implements the IRepository interface
 *
 * @param <TYPE> the TYPE of the id
 * @param <T>    the type of the object that uses a TYPE-type id
 */
public class Repository<TYPE, T extends BaseObject<TYPE>> implements IRepository<TYPE, T> {
    Map<TYPE, T> elements;
    IValidator<T> validator;

    //public Repository(){}

    public Repository(IValidator<T> val) {
        this.elements = new HashMap<>();
        this.validator = val;
    }

    public Optional<T> add(T elem) {
        if (elem == null)
            throw new IllegalArgumentException("invalid add! item is null!");
        validator.validate(elem);
        return Optional.ofNullable(elements.putIfAbsent(elem.getId(), elem));
    }

    public Optional<T> delete(TYPE id) {
        if (id == null)
            throw new IllegalArgumentException("invalid delete! id is null!");
        if (!elements.containsKey(id))
            throw new IllegalArgumentException("invalid delete! given id does not exist!");
        return Optional.ofNullable(elements.remove(id));
    }

    public Optional<T> update(T elem) {
        if (elem == null)
            throw new IllegalArgumentException("invalid update! item is null!");
        validator.validate(elem);
        return Optional.ofNullable(elements.computeIfPresent(elem.getId(), (k, v) -> elem));
    }

    public Optional<T> find(TYPE id) {
        if (id == null)
            throw new IllegalArgumentException("invalid find! id is null!");

        return Optional.ofNullable(elements.get(id));
    }

    public Iterable<T> findAll() {
        return elements.values();
    }

    Map<TYPE, T> getElements() {
        return this.elements;
    }
}
