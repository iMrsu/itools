package com.miaoc.itools.genealogy.entity;

import java.util.List;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-11-23 23:52
 **/

public class GenealTree {

    /**
     * 组织id
     */
    private String orgId;

    private String orgName;

    private String orgDesc;

    private Integer orderNo;

    private String pid;

    private String userId;


    /**
     * 姓名
     */
    private String username;

    /**
     * 姓氏
     */
    private String lastname;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 字号
     */
    private String epithet;

    /**
     * 称谓
     */
    private String appellation;

    /**
     * 生日
     */
    private Integer birthday;

    /**
     * 性别 1--男，2--女，0--未知
     */
    private String sex;

    /**
     * 辈分
     */
    private String familySeniority;

    /**
     * 世系
     */
    private String lineage;

    /**
     * 代数
     */
    private String algebra;

    /**
     * 长次
     */
    private String elderOrder;

    /**
     * 生存  健在 已故
     */
    private String subsist;

    /**
     * 妻子姓名
     */
    private String wifeName;

    private String wifeLastname;

    private String remark;

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private List<GenealTree> genealTree;

    public List<GenealTree> getGenealTree() {
        return genealTree;
    }

    public void setGenealTree(List<GenealTree> genealTree) {
        this.genealTree = genealTree;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEpithet() {
        return epithet;
    }

    public void setEpithet(String epithet) {
        this.epithet = epithet;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFamilySeniority() {
        return familySeniority;
    }

    public void setFamilySeniority(String familySeniority) {
        this.familySeniority = familySeniority;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public String getAlgebra() {
        return algebra;
    }

    public void setAlgebra(String algebra) {
        this.algebra = algebra;
    }

    public String getElderOrder() {
        return elderOrder;
    }

    public void setElderOrder(String elderOrder) {
        this.elderOrder = elderOrder;
    }

    public String getSubsist() {
        return subsist;
    }

    public void setSubsist(String subsist) {
        this.subsist = subsist;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
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
