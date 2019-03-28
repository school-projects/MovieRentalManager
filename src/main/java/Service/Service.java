package Service;

import Model.BaseObject;
import Repository.Paging.IPage;
import Repository.Paging.IPageable;
import Repository.Paging.Implementation.Page;
import Repository.Paging.Implementation.Pageable;
import Repository.Paging.PagingRepository;
import Repository.JDBCRepository;
import Validation.IValidator;
import Repository.IRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Abstract Service class
 *
 * @param <K> the id type for object type T
 * @param <T> object type
 */
public abstract class Service<K extends Serializable, T extends BaseObject<K>> {
    protected PagingRepository<K, T> repo;
    private IPageable pag;


    /**
     * Creates a Service instance based on a given repository
     *
     * @param repo existing repository
     */
    public Service(PagingRepository<K, T> repo) {
        this.repo = repo;
        this.pag = new Pageable(0,3);
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

    public IPage<T> getNextPage() {
        IPage<T> p = repo.findAll(pag);
        pag = p.nextPageable();
        return p;
    }

    public void resetPage(){
        pag = new Pageable(0,pag.getPageSize());
    }

    public void setPageSize(Integer sz){
        pag = new Pageable(0, sz);
    }
}
