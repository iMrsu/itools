package com.miaoc.itools.message.utils;

import com.miaoc.itools.message.annotation.MsgTypeHandler;
import com.miaoc.itools.message.service.IMessageService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: formeal
 * @description: 通过解析注解，将消息类型->消息处理对象的映射关系保存到MessageServiceContext对象中
 * @author: Mr.cc
 * @create: 2020-07-19 17:14
 **/

@Component
public class MessageServiceListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MsgTypeHandler.class);
        MessageServiceContext messageServiceContext = event.getApplicationContext().getBean(MessageServiceContext.class);
        beans.forEach((name, bean) -> {
            MsgTypeHandler typeHandler = bean.getClass().getAnnotation(MsgTypeHandler.class);
            messageServiceContext.putMessageService(typeHandler.value().code, (IMessageService) bean);
        });
    }
}

