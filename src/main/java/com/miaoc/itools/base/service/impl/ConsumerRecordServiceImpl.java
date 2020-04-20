package com.miaoc.itools.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ConsumerRecord;
import com.miaoc.itools.base.mapper.ConsumerRecordMapper;
import com.miaoc.itools.base.service.IConsumerRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoc.itools.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
@Service("iConsumerRecordService")
public class ConsumerRecordServiceImpl extends ServiceImpl<ConsumerRecordMapper, ConsumerRecord> implements IConsumerRecordService {

    @Resource
    private ConsumerRecordMapper consumerRecordMapper;

    @Autowired
    private BaseUtils baseUtils;

    @Override
    public List<ConsumerRecord> getConsumerRecord(JSONObject req) {
        String nowData = baseUtils.getDatatime();
        List<ConsumerRecord> list = consumerRecordMapper.getConsumerRecord(nowData);
        return list;
    }
    @Override
    public List<ConsumerRecord> getConsumerRecordHis(JSONObject req) {
        String nowData = baseUtils.getDatatime();
        List<ConsumerRecord> list = consumerRecordMapper.getConsumerRecordHis(nowData);
        return list;
    }
}
