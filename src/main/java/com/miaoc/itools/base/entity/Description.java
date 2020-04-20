package com.miaoc.itools.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
@TableName("description")
public class Description implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 菜品种类id
     */
    @TableId("description_Id")
    private String descriptionId;

    /**
     * 菜品种类id名称
     */
    @TableField("name")
    private String name;

    @TableField("type")
    private Integer type;

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

    private List<Dishes> foods;

    public String getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescriptionName() {
        return name;
    }

    public void setDescriptionName(String descriptionName) {
        this.name = descriptionName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public List<Dishes> getDishes() {
        return foods;
    }

    public void setDishes(List<Dishes> dishes) {
        this.foods = dishes;
    }

    @Override
    public String toString() {
        return "Description{" +
        "descriptionId=" + descriptionId +
        ", descriptionName=" + name +
        ", type=" + type +
        ", describes=" + describes +
        ", remarks=" + remarks +
        "}";
    }
}
