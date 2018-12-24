package net.seehope.college.core;

/**
 * @Description：编码枚举类
 * @Author：lxgy
 * @Date：2018-12-24
 */
public enum CodeEnum {

    /*成功*/
    _200(200, "success"), _500(500, "faile"), _404(404, "resources missing"), _403(403, "refuse execute"), _505(505, "server not support");

    private String msg;
    private Integer code;

    CodeEnum(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
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
}
