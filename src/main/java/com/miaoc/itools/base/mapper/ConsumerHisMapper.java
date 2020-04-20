package com.miaoc.itools.base.mapper;

import com.miaoc.itools.base.entity.ConsumerHis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoc.itools.base.entity.ConsumerRecord;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
public interface ConsumerHisMapper extends BaseMapper<ConsumerHis> {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int createBatchConsumerHisList(List<ConsumerHis> list);

}
