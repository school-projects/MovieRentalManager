package Repository;

import Model.BaseObject;
import Exceptions.RepositoryException;

import java.util.Optional;

/**
 * Generic Repository Interface for storing T-type objects, with TYPE-type id
 *
 * @param <TYPE>
 * @param <T>
 */
public interface IRepository<TYPE, T extends BaseObject<TYPE>> {
    /**
     * adds the given T-type element to the repository
     *
     * @param elem must not be null
     * @throws RepositoryException if the given element is null
     * @throws RepositoryException if the given element already exists
     */
    Optional<T> add(T elem);

    /**
     * deletes the element with the given id from the repository
     *
     * @param id must not be null
     * @return an {@code Optional} - null if the entity was saved otherwise (e.g. id already exists) returns the entity.
     * @throws RepositoryException if the element is null
     * @throws RepositoryException if the given id does not exist in the repository
     */
    Optional<T> delete(TYPE id);

    /**
     * updates a given element in the repository by the new elem's id
     *
     * @param elem must not be null
     * @return an {@code Optional} - null if there is no entity with the given id, otherwise the removed entity
     * @throws RepositoryException if the id is null
     * @throws RepositoryException if the given id is not in the repository in the first place
     */
    Optional<T> update(T elem);

    /**
     * finds an element in the repository by the given id
     *
     * @param id must not be null
     * @throws RepositoryException if the given id is null
     * @return an {@code Optional} - null if the entity was updated otherwise (e.g. id does not exist) returns the
     *         entity.
     */
    Optional<T> find(TYPE id);

    /**
     * finds all the elements in the repository
     *
     * @return an Iterable<T> object
     */
    Iterable<T> findAll();
}
