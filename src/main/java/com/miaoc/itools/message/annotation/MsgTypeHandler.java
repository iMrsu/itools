package com.miaoc.itools.message.annotation;

import com.miaoc.itools.message.enums.MSG_TYPE;

import java.lang.annotation.*;

/**
 * 定义一个注解
 * @Author: Mr.cc
 * @Date: 2020/7/23
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MsgTypeHandler {

    MSG_TYPE value();

}
