package net.seehope.college.vo;

/**
 * @Description: ${结果集}
 * ====================================
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.vo
 * @Author: lxgy
 * @CreateTime: 2018-12-14 08:41
 */
public class ResultVo<T> {
    /*状态编码*/
    private Integer code;
    /*信息*/
    private String msg;
    /*数据*/
    private T data;

    /*无参构造器*/
    public ResultVo() {
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
