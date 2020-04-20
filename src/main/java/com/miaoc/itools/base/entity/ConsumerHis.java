package com.miaoc.itools.base.entity;

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
 * @since 2019-07-20
 */
@TableName("consumer_his")
public class ConsumerHis implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 历史明细id
     */
    @TableId("id")
    private String id;

    /**
     * 菜品id
     */
    @TableField("dishes_id")
    private String dishesId;

    /**
     * 记录id
     */
    @TableField("record_id")
    private String recordId;

    /**
     * 描述
     */
    @TableField("describes")
    private String describes;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishesId() {
        return dishesId;
    }

    public void setDishesId(String dishesId) {
        this.dishesId = dishesId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ConsumerHis{" +
        "id=" + id +
        ", dishesId=" + dishesId +
        ", recordId=" + recordId +
        ", describes=" + describes +
        ", remarks=" + remarks +
        "}";
    }
}
