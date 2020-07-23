package com.miaoc.itools.message.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
public class MessageInfo implements Serializable {

private static final long serialVersionUID=1L;

    // 消息类型
    private Integer type;
    // 消息内容
    private String content;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageInfo(Integer type, String content) {
        this.type = type;
        this.content = content;
    }
}
