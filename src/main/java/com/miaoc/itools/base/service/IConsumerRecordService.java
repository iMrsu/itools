package com.miaoc.itools.base.service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoc.itools.base.entity.ConsumerRecord;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
public interface IConsumerRecordService extends IService<ConsumerRecord> {

    List<ConsumerRecord> getConsumerRecord(JSONObject req);

    List<ConsumerRecord> getConsumerRecordHis(JSONObject req);

}
