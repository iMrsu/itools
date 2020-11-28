package com.miaoc.itools.base.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ConsumerRecord;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.base.service.IConsumerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2019-07-20
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/base")
public class ConsumerRecordController {

    @Autowired
    private IConsumerRecordService iConsumerRecordService;

    @RequestMapping(value = "/getConsumerRecord")
    @ResponseBody
    public ResBody makeOrder(@RequestBody JSONObject req) throws Exception {
        ResBody res = new ResBody();//返回值
        List<ConsumerRecord> result = iConsumerRecordService.getConsumerRecord(req);
        res.setStatus(1);
        res.setResData(result);
        res.setMsg("成功");
        return res;
    }

    @RequestMapping(value = "/getConsumerRecordHis")
    @ResponseBody
    public ResBody getConsumerRecordHis(@RequestBody JSONObject req) throws Exception {
        ResBody res = new ResBody();//返回值
        List<ConsumerRecord> result = iConsumerRecordService.getConsumerRecordHis(req);
        res.setStatus(1);
        res.setResData(result);
        res.setMsg("成功");
        return res;
    }

}

