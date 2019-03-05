package Repository;

import Model.BaseObject;
import Exception.RepositoryException;
/**
 * Generic Repository Interface for storing T-type objects, with TYPE-type id
 * @param <TYPE>
 * @param <T>
 */
public interface IRepository<TYPE,T extends BaseObject<TYPE>> {
    /**
     * adds the given T-type element to the repository
     * @param elem
     *              must not be null
     * @throws RepositoryException if the given element is null
     * @throws RepositoryException if the given element already exists
     */
    void add(T elem);

    /**
     * deletes the element with the given id from the repository
     * @param id
     *          must not be null
     * @throws RepositoryException if the element is null
     * @throws RepositoryException if the given id does not exist in the repository
     */
    void delete(TYPE id);

    /**
     * updates a given element in the repository by the new elem's id
     * @param elem
     *            must not be null
     * @throws RepositoryException if the id is null
     * @throws RepositoryException if the given id is not in the repository in the first place
     */
    void update(T elem);

    /**
     * finds an element in the repository by the given id
     * @param id
     *          must not be null
     * @throws RepositoryException if the given id is null
     */
    T find(TYPE id);

    /**
     * finds all the elements in the repository
     * @return an Iterable<T> object
     */
    Iterable<T> findAll();
}
