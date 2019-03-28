package Repository.Paging;

import Repository.Paging.Implementation.Page;

import java.util.stream.Stream;

public class Paginator<T> {

    public IPage<T> page(Stream<T> elems, IPageable p){
        return new Page<>(p, elems.skip(p.getPageNumber()*p.getPageSize()).limit(p.getPageSize()));
    }
}
