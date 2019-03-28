package Repository.Paging;


import Model.BaseObject;
import Repository.IRepository;

import java.io.Serializable;

public interface PagingRepository<ID extends Serializable, T extends BaseObject<ID>> extends IRepository<ID, T> {

    IPage<T> findAll(IPageable pageable);

}
