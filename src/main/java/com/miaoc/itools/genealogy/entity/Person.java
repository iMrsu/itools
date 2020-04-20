package com.miaoc.itools.genealogy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
public class Person implements Serializable {

private static final long serialVersionUID=1L;

    @TableId("user_id")
    private String userId;

    /**
     * 姓名
     */
    @TableField("username")
    private String username;


    /**
     * 字号 - 昭
     */
    @TableField("epithet")
    private String epithet;

    /**
     * 世系
     */
    @TableField("lineage")
    private String lineage;

    /**
     * 长次
     */
    @TableField("elder_order")
    private String elderOrder;


    @TableField("wife_lastname")
    private String wifeLastname;

    @TableField("remark")
    private String remark;

    @TableField("child_order")
    private String childOrder;

    public String getChildOrder() {
        return childOrder;
    }

    public void setChildOrder(String childOrder) {
        this.childOrder = childOrder;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEpithet() {
        return epithet;
    }

    public void setEpithet(String epithet) {
        this.epithet = epithet;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public String getElderOrder() {
        return elderOrder;
    }

    public void setElderOrder(String elderOrder) {
        this.elderOrder = elderOrder;
    }

    public String getWifeLastname() {
        return wifeLastname;
    }

    public void setWifeLastname(String wifeLastname) {
        this.wifeLastname = wifeLastname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
