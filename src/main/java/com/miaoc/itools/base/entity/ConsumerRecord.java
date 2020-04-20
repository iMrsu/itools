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
 * @since 2019-07-20
 */
@TableName("description")
public class ConsumerRecord implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 消费记录编号
     */
    @TableId("record_id")
    private String recordId;

    /**
     * 桌号
     */
    @TableField("table_id")
    private String tableId;

    /**
     * 消费总数
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 消费日期
     */
    @TableField("consumer_data")
    private String consumerData;

    @TableField("describes")
    private String describes;

    @TableField("remarks")
    private String remarks;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConsumerData() {
        return consumerData;
    }

    public void setConsumerData(String consumerData) {
        this.consumerData = consumerData;
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
        return "ConsumerRecord{" +
        "recordId=" + recordId +
        ", tableId=" + tableId +
        ", totalPrice=" + totalPrice +
        ", consumerData=" + consumerData +
        ", describes=" + describes +
        ", remarks=" + remarks +
        "}";
    }
}
