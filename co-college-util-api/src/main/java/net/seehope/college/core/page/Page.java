package net.seehope.college.core.page;

import java.util.List;

/**
 * @param <T>
 * @Description：分页api.
 * @Author：lxgy
 * @Date：2018-12-24
 */
public class Page<T> {
    /*数据*/
    private List<T> datas;
    /*第几页*/
    private Integer page_no;
    /*每页数据条数*/
    private Integer page_size;
    /*最大分页数*/
    private Integer max_page;
    /*数据条数*/
    private Integer total;

    public Page() {
    }

    public Page(PageRequest pageRequest,List<T> datas,Integer total){
        this.page_no = pageRequest.getPage_no();
        this.page_size = pageRequest.getPage_size();
        this.total = total;
        this.max_page = total / this.page_size;
        if(total % this.page_size != 0){
            max_page = (this.getMax_page() + 1);
        }
    }

   /* public Page(List<T> datas, Integer page_no, Integer page_size, Integer max_page, Integer total) {
        this.datas = datas;
        this.page_no = page_no;
        this.page_size = page_size;
        this.max_page = (total / page_size);
        if (total % page_size != 0) {
            this.max_page = (this.getMax_page() + 1);
        }
        this.total = total;
    }
*/
    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
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

    public Integer getMax_page() {
        return max_page;
    }

    public void setMax_page(Integer max_page) {
        this.max_page = max_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
