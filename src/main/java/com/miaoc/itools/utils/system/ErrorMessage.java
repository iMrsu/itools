package com.miaoc.itools.utils.system;

/**
 * 错误提示集合类
 * 错误码构成：   01程序员编号
 * 001该程序员定义的错误码
 * 后面再跟上错误信息
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-08-24 16:38
 **/
public final class ErrorMessage {
    public static final String SYSTEM_EXCEPTION = "系统繁忙，请稍后再试";
    public static final String NOT_LOGIN = "01001_您还未登陆或者登陆已超时，请重新登陆";
    public static final String MOBILE_ALREADY_REGISTER = "01002_该手机号已经被注册了";
    public static final String LOGIC_EXCEPTION = "ohh_对不起，你是真的很帅";
    public static final String NO_TOKEN = "请求中未包含_token参数值";
}
