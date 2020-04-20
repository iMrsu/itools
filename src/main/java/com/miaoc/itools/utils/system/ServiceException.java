package com.miaoc.itools.utils.system;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-08-24 16:03
 **/

public class ServiceException extends RuntimeException{

    private Integer code;

    private String desc;

    public ServiceException(Integer code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
