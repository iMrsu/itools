package com.miaoc.itools.utils.interceptor;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miaoc.itools.base.entity.ResBody;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * Controller自定义拦截器
 *
 * @author Zhaidk
 * @create 2017年12月18日 16点02分
 */
@Configuration
public class ControllerInterceptor implements HandlerInterceptor {

	private static Logger log = Logger.getLogger(ControllerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		if (handler instanceof HandlerMethod) {
			StringBuilder sb = new StringBuilder(1000);
			sb.append("-----------------------").append(SimpleDateFormatCache(new Date()))
					.append("-------------------------------------\n");
			HandlerMethod h = (HandlerMethod) handler;
			sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
			sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
			sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
			sb.append("URI       : ").append(request.getRequestURI()).append("\n");
			
			HttpSession session = request.getSession();
			String userAgent = request.getHeader("user-agent");
			if (userAgent.indexOf("Android") != -1) {
				// 安卓
				System.out.println("Android访问！！！");
				
			} else if (userAgent.indexOf("iPhone") != -1 || userAgent.indexOf("iPad") != -1) {
			    // 苹果
				System.out.println("iPhone/iPad访问！！！");
			    
			} else {
				// 电脑
				System.out.println("web电脑访问！！！");
				/*if (session.getAttribute("login_user") == null) {
					System.out.println(sb.toString());
					log.info("用户未登录，请先登录");
					response.setCharacterEncoding("gbk");
					PrintWriter writer = response.getWriter();
					writer.print(JSON.toJSON(new ResBody(-1, "用户未登录，请先登录")));
					response.sendRedirect(request.getContextPath()+"/views");
					return false;
				}
				else{
					// 获取登陆用户信息

				}*/
			}
//			System.out.println(sb.toString());
		}
		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		if (handler instanceof HandlerMethod) {
			StringBuilder sb = new StringBuilder(1000);
			sb.append("CostTime  : ").append(executeTime).append("ms").append("\n");
			sb.append("-------------------------------------------------------------------------------");
			System.out.println(sb.toString());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

	private String getParamString(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String[]> e : map.entrySet()) {
			sb.append(e.getKey()).append("=");
			String[] value = e.getValue();
			if (value != null && value.length == 1) {
				sb.append(value[0]).append("\t");
			} else {
				sb.append(Arrays.toString(value)).append("\t");
			}
		}
		return sb.toString();
	}

	public static String SimpleDateFormatCache(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

}