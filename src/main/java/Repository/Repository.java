package Repository;

import Model.BaseObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Exception.RepositoryException;

public class Repository<TYPE,T extends BaseObject<TYPE>> implements IRepository<TYPE,T> {
    private Map<TYPE,T> elements;
    public Repository(){this.elements= new HashMap<>();}

    public void add(T elem){
        if(elements.containsKey(elem.getId()))
            throw new RepositoryException("invalid id! item with same id already exists!");
        elements.put(elem.getId(),elem);
    }

    public void delete(TYPE id){
        if(!elements.containsKey(id))
            throw new RepositoryException("no such object in the repository!");
        elements.remove(id);
    }

    public void update(T elem){
        if(elements.containsKey(elem.getId()))
            throw new RepositoryException("cannot update non-existing objects");
        elements.replace(elem.getId(),elem);
    }

    public T find(TYPE id){
        if(!elements.containsKey(id))
            throw new RepositoryException("no such object in the repository!");
        return elements.get(id);
    }

    public Iterable<T> findAll(){
        return elements.values();
    }
}
