package net.seehope.college.core.page;

public class PageRequest {
    /*第几页*/
    private Integer page_no;
    /*每页数据条数*/
    private Integer page_size;

    public PageRequest() {
        this.page_no = 1;
        this.page_size = 10;
    }

    public PageRequest(Integer page_no, Integer page_size) {
        if (page_no <= 0) {
            page_no = 1;
        }
        if (page_size <= 0) {
            page_size = 10;
        }
        this.page_no = 1;
        this.page_size = 10;
    }

    public Integer getPage_no() {
        return page_no;
    }

    public void setPage_no(Integer page_no) {
        this.page_no = page_no;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }
}
