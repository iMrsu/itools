package com.miaoc.itools.tools.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.tools.service.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2019-10-20
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/itools")
public class MessageController {

    @Autowired
    private IMessagesService iMessageService;
    @RequestMapping(value = "/messageSend")
    @ResponseBody
    public Object message(@RequestBody JSONObject req) throws Exception {
        Object output=iMessageService.message(req);
        return output;
    }
}

