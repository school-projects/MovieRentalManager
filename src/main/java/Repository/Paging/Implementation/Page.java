package Repository.Paging.Implementation;

import Repository.Paging.IPage;
import Repository.Paging.IPageable;

import java.util.stream.Stream;

public class Page<T> implements IPage<T> {

    private IPageable pageable;
    private Stream<T> content;

    public Page(IPageable pageable, Stream<T> content) {
        this.pageable = pageable;
        this.content = content;
    }

    @Override
    public IPageable getPageable() {
        return pageable;
    }

    @Override
    public IPageable nextPageable() {
        return new Pageable(pageable.getPageSize(), pageable.getPageNumber());
    }

    @Override
    public Stream<T> getContent() {
        return content;
    }
}
