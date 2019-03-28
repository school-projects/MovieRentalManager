package Repository.Paging.Implementation;

import Repository.Paging.IPageable;

public class Pageable implements IPageable {

    private Integer pageNr;
    private Integer pageSz;

    public Pageable(Integer pageNr, Integer pageSz) {
        this.pageNr = pageNr;
        this.pageSz = pageSz;
    }

    @Override
    public Integer getPageNumber() {
        return pageNr;
    }

    @Override
    public Integer getPageSize() {
        return pageSz;
    }
}
