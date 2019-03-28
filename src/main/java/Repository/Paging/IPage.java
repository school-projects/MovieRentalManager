package Repository.Paging;

import java.util.stream.Stream;

public interface IPage<T> {

    IPageable getPageable();

    IPageable nextPageable();

    Stream<T> getContent();

}
