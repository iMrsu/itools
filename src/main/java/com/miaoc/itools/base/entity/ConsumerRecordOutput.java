package com.miaoc.itools.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
@TableName("description")
public class ConsumerRecordOutput implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 消费记录编号
     */
    @TableId("record_id")
    private String record_id;

    /**
     * 桌号
     */
    @TableField("table_id")
    private String table_id;

    /**
     * 消费总数
     */
    @TableField("total_price")
    private BigDecimal total_price;

    /**
     * 消费日期
     */
    @TableField("consumer_data")
    private String consumer_data;

    @TableField("describes")
    private String describes;

    @TableField("remarks")
    private String remarks;

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getTable_id() {
        return table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getConsumer_data() {
        return consumer_data;
    }

    public void setConsumer_data(String consumer_data) {
        this.consumer_data = consumer_data;
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
}
