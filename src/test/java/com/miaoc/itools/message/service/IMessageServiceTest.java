package com.miaoc.itools.message.service;

import com.miaoc.itools.message.entity.MessageInfo;
import com.miaoc.itools.message.enums.MSG_TYPE;
import com.miaoc.itools.message.utils.MessageServiceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IMessageServiceTest {

    @Autowired
    MessageServiceContext messageServiceContext;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void handleMessage() {
        // 构建一个文本消息
        MessageInfo messageInfo = new MessageInfo(MSG_TYPE.TEXT.code, "消息内容");
        IMessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        // 处理文本消息 消息内容
        // 可以看到文本消息被文本处理类所处理
        messageService.handleMessage(messageInfo);
    }
}
