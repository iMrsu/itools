package com.miaoc.itools.tools.controller;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.utils.AESUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-10-27 14:17
 **/

@CrossOrigin("*")
@RestController
@RequestMapping("/app")
public class CryptoController {

    @RequestMapping(value = "/crypto")
    @ResponseBody
    public Object crypto(@RequestBody JSONObject req) throws Exception {
        AESUtils aesUtils=new AESUtils();
        String model=(String) req.get("data");
        String desData=aesUtils.desEncrypt(model);
        JSONObject resultData=new JSONObject();
        if(desData==null){
            resultData=AESUtils.encrypt(resultData.toString());//json转string后加密
            return resultData;
        }
        resultData.put("data","success");
        resultData=AESUtils.encrypt(resultData.toString());//json转string后加密
        return resultData;
    }

}
