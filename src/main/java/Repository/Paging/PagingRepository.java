package Repository.Paging;


import Model.BaseObject;
import Repository.IRepository;

import java.io.Serializable;

/**
 * author: radu
 */
public interface PagingRepository<ID extends Serializable, T extends BaseObject<ID>> extends IRepository<ID, T> {

    Page<T> findAll(Pageable pageable);

}
