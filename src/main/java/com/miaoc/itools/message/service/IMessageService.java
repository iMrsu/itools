package com.miaoc.itools.message.service;

import com.miaoc.itools.message.entity.MessageInfo;

/**
 * <p>
 *  定义一个消息处理接口
 * </p>
 * 定义策略接口
 * @author cc
 * @since 2019-11-23
 */
public interface IMessageService{
    void handleMessage(MessageInfo messageInfo);
}
