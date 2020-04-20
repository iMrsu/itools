package com.miaoc.itools.genealogy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
@TableName("geneal")
public class Genealogy implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 组织id
     */

    @TableId("org_id")
    private String orgId;

    @TableField("order_no")
    private Integer orderNo;

    /**
     * 父ID
     */
    @TableField("pid")
    private String pid;

    /**
     * person
     */
    @TableField("user_id")
    private String userId;

    @TableField("remake")
    private String remake;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}
