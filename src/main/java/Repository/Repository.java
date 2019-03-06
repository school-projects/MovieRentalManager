package Repository;

import Model.BaseObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Exception.RepositoryException;

/**
 * In-Memory Repository that implements the IRepository<TYPE,T extends BaseObject<TYPE>> interface
 * @param <TYPE>
 *     the TYPE of the id
 * @param <T>
 *     the type of the object that uses a TYPE-type id
 */
public class Repository<TYPE,T extends BaseObject<TYPE>> implements IRepository<TYPE,T> {
    private Map<TYPE,T> elements;
    public Repository(){this.elements= new HashMap<>();}

    public void add(T elem){
        if(elem == null)
            throw new RepositoryException("invalid add! item is null!");
        if(elements.containsKey(elem.getId()))
            throw new RepositoryException("invalid id! item with same id already exists!");
        elements.put(elem.getId(),elem);
    }

    public void delete(TYPE id){
        if(id == null)
            throw new RepositoryException("invalid delete! id is null!");
        if(!elements.containsKey(id))
            throw new RepositoryException("no such object in the repository!");
        elements.remove(id);
    }

    public void update(T elem){
        if(elem == null)
            throw new RepositoryException("invalid update! item is null!");
        if(elements.containsKey(elem.getId()))
            throw new RepositoryException("cannot update non-existing objects");
        elements.replace(elem.getId(),elem);
    }

    public T find(TYPE id){
        if(id == null)
            throw new RepositoryException("invalid find! id is null!");
        if(!elements.containsKey(id))
            throw new RepositoryException("no such object in the repository!");
        return elements.get(id);
    }

    public Iterable<T> findAll(){
        return elements.values();
    }
}
