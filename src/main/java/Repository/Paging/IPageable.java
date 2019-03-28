package Repository.Paging;

public interface IPageable {
    /**
     * @return page number; page numbers start at 0.
     */
    Integer getPageNumber();

    /**
     * @return the number of elements in a page.
     */
    Integer getPageSize();
}
