package com.miaoc.itools.base.mapper;

import com.miaoc.itools.base.entity.ConsumerRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
public interface ConsumerRecordMapper extends BaseMapper<ConsumerRecord> {


    /**
     * 点餐记录
     * @return
     */
    boolean addConsumeRecord(ConsumerRecord consumerRecord);

    @Select("SELECT * FROM consumer_record WHERE consumer_data = #{nowData}")
    List<ConsumerRecord> getConsumerRecord(String nowData);

    @Select("SELECT * FROM consumer_record ")
    List<ConsumerRecord> getConsumerRecordHis(String nowData);
}
