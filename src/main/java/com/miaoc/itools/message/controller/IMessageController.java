package com.miaoc.itools.message.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.message.entity.MessageInfo;
import com.miaoc.itools.message.enums.MSG_TYPE;
import com.miaoc.itools.message.service.IMessageService;
import com.miaoc.itools.message.utils.MessageServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用策略模式根据消息的不同类型来做不同的处理
 *
 * 定义一个接口，有多个实现类，每种实现类封装了一种行为、
 * 然后根据条件的不同选择不同的实现类。
 *
 * 不必修改接口
 * 一个项目中有许多类，它们之间的区别仅在于它们的行为，希望动态地让一个对象在许多行为中选择一种行为时；
 * 一个项目需要动态地在几种算法中选择一种时；
 * 一个对象有很多的行为，不想使用多重的条件选择语句来选择使用哪个行为时。
 *
 * @author cc
 */
@RestController
@RequestMapping("/message")
public class IMessageController {
    @Autowired
    MessageServiceContext messageServiceContext;

    @RequestMapping(value = "/getMessage")
    @ResponseBody
    public Object getMessage( ) {
        // 构建一个文本消息
        MessageInfo messageInfo = new MessageInfo(MSG_TYPE.TEXT.code, "消息内容");
        IMessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        // 处理文本消息 消息内容
        // 可以看到文本消息被文本处理类所处理
        messageService.handleMessage(messageInfo);
        return new JSONObject();
    }


}

