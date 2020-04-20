package com.miaoc.itools.tools.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-10-20
 */
public class Message implements Serializable {

private static final long serialVersionUID=1L;

    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
        "id=" + id +
        "}";
    }
}
