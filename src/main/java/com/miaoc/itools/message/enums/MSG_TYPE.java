package com.miaoc.itools.message.enums;
/**
 * @Description: 消息类型的枚举类
 * @Param: 
 * @return: 
 * @Date: 2020/7/23
 */ 
public enum MSG_TYPE {
    TEXT(1, "文本"),
    IMAGE(2, "图片"),
    VIDEO(3, "视频");

    public final int code;
    public final String name;

    MSG_TYPE(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
