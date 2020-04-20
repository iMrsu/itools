package com.miaoc.itools.genealogy.entity;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-11-23 23:52
 **/

public class GenealGetInput {

    /**
     * 组织id
     */
    private String orgId;

    private String pid;

    private String userId;


    /**
     * 姓名
     */
    private String username;

    /**
     * 字号
     */
    private String epithet;

    /**
     * 世系
     */
    private String lineage;

    /**
     * 长次
     */
    private String elderOrder;

    private String wifeLastname;

    private String remark;

    private String childOrder;

    public String getChildOrder() {
        return childOrder;
    }

    public void setChildOrder(String childOrder) {
        this.childOrder = childOrder;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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
