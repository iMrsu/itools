package com.miaoc.itools.message.service.impl;

import com.miaoc.itools.message.annotation.MsgTypeHandler;
import com.miaoc.itools.message.entity.MessageInfo;
import com.miaoc.itools.message.enums.MSG_TYPE;
import com.miaoc.itools.message.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  处理图片消息
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
@Service
@MsgTypeHandler(value = MSG_TYPE.IMAGE)
public class ImageMessageServiceImpl implements IMessageService {

    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("处理图片消息 " + messageInfo.getContent());
    }
}
