package Repository.Paging;

import Model.BaseObject;
import Repository.Paging.Implementation.Page;

import java.util.Comparator;
import java.util.stream.Stream;

public class Paginator<T extends BaseObject> {

    public IPage<T> page(Stream<T> elems, IPageable p){
        return new Page<>(p, elems.skip(p.getPageNumber()*p.getPageSize()).limit(p.getPageSize()));
    }
}
