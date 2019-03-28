package Repository;

import Model.BaseObject;
import Repository.Paging.IPage;
import Repository.Paging.IPageable;
import Repository.Paging.PagingRepository;
import Validation.IValidator;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

public class JDBCRepository<ID extends Serializable, T extends BaseObject<ID>> implements PagingRepository<ID, T>{

    Map<ID, T> elements;
    IValidator<T> validator;

    @Override
    public IPage<T> findAll(IPageable pageable) {
        return null;
    }

    @Override
    public Optional<T> add(T elem) {

        return Optional.empty();
    }

    @Override
    public Optional<T> delete(ID id) {
        return Optional.empty();
    }

    @Override
    public Optional<T> update(T elem) {
        return Optional.empty();
    }

    @Override
    public Optional<T> find(ID id) {
        return Optional.empty();
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }
}
