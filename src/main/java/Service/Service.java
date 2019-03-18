package Service;

import Model.BaseObject;
import Repository.Repository;
import Validation.IValidator;

import java.util.Optional;

/**
 * Abstract Service class
 *
 * @param <K> the id type for object type T
 * @param <T> object type
 */
public abstract class Service<K, T extends BaseObject<K>> {
    Repository<K, T> repo;

    /**
     * Creates a Service instance with an empty repository
     *
     * @param validator validator used in repository
     */
    public Service(IValidator<T> validator) {
        this.repo = new Repository<>(validator);
    }

    /**
     * Creates a Service instance based on a given repository
     *
     * @param repo existing repository
     */
    public Service(Repository<K, T> repo) {
        this.repo = repo;
    }

    /**
     * Adds an object to the underlying repository
     *
     * @param obj object of type T to be added
     */

    void add(T obj) {
        this.repo.add(obj);
    }

    public Optional<T> get(K key) {
        return this.repo.find(key);
    }

    /**
     * Deletes an object from the underlying repository
     *
     * @param id the key from which the object will be deleted
     */
    public void delete(K id) {
        this.repo.delete(id);
    }

    /**
     * Replaces an object in the underlying repository with another based on its id
     *
     * @param obj the object that will replace the object present in the repository
     */
    public Optional<T> update(T obj) {
        return this.repo.update(obj);
    }

    /**
     * Gets all repository objects
     *
     * @return list of all items in repository
     */
    public Iterable<T> getAll() {
        return this.repo.findAll();
    }
}
