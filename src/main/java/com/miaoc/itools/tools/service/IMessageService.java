package com.miaoc.itools.tools.service;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.tools.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-10-20
 */
public interface IMessageService extends IService<Message> {

    Object message (@RequestBody JSONObject req);

}
