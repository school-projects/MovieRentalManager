package Service;

import Model.BaseObject;
import Repository.Repository;
import Validation.IValidator;

/**
 * Abstract Service class
 *
 * @param <K> the id type for object type T
 * @param <T> object type
 */
public abstract class Service<K, T extends BaseObject<K>> {
    protected Repository<K, T> repo;

    /**
     * Creates a Service instance with an empty repository
     *
     * @param validator validator used in repository
     */
    public Service(IValidator<T> validator) {
        this.repo = new Repository<K, T>(validator);
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
    public void add(T obj) {
        this.repo.add(obj);
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
