package com.miaoc.itools.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-07-20 16:10
 **/
@Service
public class BaseUtils {

    private static Logger logger = LoggerFactory.getLogger(BaseUtils.class);
    /**
     * @Description: 获取UUID
     * @Param:
     * @return:
     * @Author: Mr.cc
     * @Date: 2019/7/20
     */
    public String getUUID(){
        String uuid=UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    /** 
     * @Description: 系统时间
     * @Param:  
     * @return:  
     * @Author: Mr.cc 
     * @Date: 2019/7/20 
     */ 
    public String getDatatime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date()).replaceAll("\\D", "");
    }



    /**
     * 将子功能返回的出参(src对象的值)拷贝到返回出参(dest对象中)
     * @param src
     * @param dest
     */
    static public <S, D> void ValueCopy(S src, D dest) {
        try {
            if (null != src) {
                BeanUtils.copyProperties(src, dest);
            }
        } catch (Exception e) {
            logger.error("出参对象值拷贝错误",e);
        }
    }



}
