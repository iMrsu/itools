package com.miaoc.itools.message.utils;

import com.miaoc.itools.message.service.IMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: formeal
 * @description: context对象保存了消息类型->消息处理对象的映射关系
 * @author: Mr.cc
 * @create: 2020-07-19 17:12
 **/
@Component
public class MessageServiceContext {
    private final Map<Integer, IMessageService> handlerMap = new HashMap<>();

    public IMessageService getMessageService(Integer type) {
        return handlerMap.get(type);
    }

    public void putMessageService(Integer code, IMessageService messageService) {
        handlerMap.put(code, messageService);
    }
}
