package com.miaoc.itools.utils.entity;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-08-24 14:13
 **/

public class Result<T> {
    // 接口调用成功或者失败 失败为 1
    private Integer code = 0;
    // 失败的具体code
    private String errorCode = "";
    // 需要传递的信息，例如错误信息
    private String msg;
    // 需要传递的数据
    private T resData;

    public Result() {
    }

    public Result(T resultBody) {
        this.resData = resultBody;
    }

    public Result( String errorCode, String msg) {
        this.code = 1;
        this.errorCode = errorCode;
        this.msg = msg;
        this.resData = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }
}
