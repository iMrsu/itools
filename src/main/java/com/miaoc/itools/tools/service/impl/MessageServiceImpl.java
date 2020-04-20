package com.miaoc.itools.tools.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.tools.entity.Message;
import com.miaoc.itools.tools.mapper.MessageMapper;
import com.miaoc.itools.tools.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoc.itools.utils.MessagePushUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-10-20
 */
@Service("iMessageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Autowired
    private MessagePushUtils messagePushUtils;

    @Override
    public Object message(JSONObject req) {
        //"{\"name\":\"名字\"}"
        String params="";
        if(!req.get("relaname").equals("")){
            params="{\"name\":\""+req.get("name")+"\",\"someone\":\""+req.get("rela")+"\",\"relaname\":\""+req.get("relaname")+"\"}";
        }else{
            params="{\"name\":\""+req.get("name")+"\",\"someone\":\""+req.get("rela")+"\"}";
        }
        req.put("params",params);
        Object obj= messagePushUtils.messagesend(req);
        return obj;
    }
}
