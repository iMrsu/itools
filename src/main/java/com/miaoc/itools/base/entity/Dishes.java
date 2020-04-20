package com.miaoc.itools.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
@TableName("Dishes")
public class Dishes implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId("dishes_id")
    private String dishesId;

    /**
     * 数量
     */
    @TableField("description_id")
    private Integer descriptionId;

    /**
     * 菜品
     */
    @TableField("name")
    private String name;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField("sell_count")
    private Integer sellCount;


    /**
     * 类别
     */
    @TableField("description")
    private String description;

    /**
     * 菜品描述
     */
    @TableField("info")
    private String info;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    public Dishes() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDishesId() {
        return dishesId;
    }

    public void setDishesId(String dishesId) {
        this.dishesId = dishesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }
}
