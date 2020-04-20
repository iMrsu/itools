package com.miaoc.itools.utils.interceptor;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-08-24 17:52
 **/

/**
 * 记录服务调用时间的拦截器
 */
@Component
public class TimeInterceptor implements HandlerInterceptor{

    private static Logger logger = Logger.getLogger(TimeInterceptor.class);
    /**
     * 处理前
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler 此参数记录了处理对象，包括类名和方法名等信息
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //设置开始时间
        httpServletRequest.setAttribute("startTime",new Date().getTime());
        //获取当前拦截接口处理类(Controller)
//        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        //获取当前拦截接口的处理方法
//        logger.info(((HandlerMethod)handler).getMethod().getName());
        //只有返回true才会执行后面的方法
        return true;
    }

    /**
     * 接口成功返回后，如果调用控制器方法时控制器方法抛出异常。则post方法不会被调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long startTime= (long) httpServletRequest.getAttribute("startTime");
        logger.info("TimeInterceptor耗时:"+(new Date().getTime()-startTime));
        System.out.println("TimeInterceptor耗时:"+(new Date().getTime()-startTime));
    }

    /**
     * 处理完成,无论控制器方法成功与否。都会进入这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception，当控制器方法抛出异常时，此exception有值,如果有全局异常处理器（参考ControllerExceptionHandler）它将拿不到异常对象
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long startTime= (long) httpServletRequest.getAttribute("startTime");
        logger.info("TimeInterceptor耗时:"+(new Date().getTime()-startTime));
        System.out.println("TimeInterceptor耗时:"+(new Date().getTime()-startTime));
    }
}
