package net.seehope.college.vo;

import java.util.List;

/**
 * @param <T>
 * @Description:分页结果集.
 * @Author:lxgy
 * @Date:2018-12-24
 */
public class PageResultVo<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private List<T> datas;

    public PageResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}

