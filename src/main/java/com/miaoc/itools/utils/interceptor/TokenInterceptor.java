
package com.miaoc.itools.utils.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miaoc.itools.utils.entity.Result;
import com.miaoc.itools.utils.system.ErrorMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * token拦截器
 * @author 夏夜梦星辰
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
	private static Logger log = Logger.getLogger(TokenInterceptor.class);
	
	/**
	 * 保存token数据的集合
	 */
	//private Map<String, String> takenMap = new HashMap<String, String>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//请求执行之前
		String token = request.getParameter("_token");
		/*if(StringUtils.isEmpty(token)) {
			log.info("请求中未包含_token参数值");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.print(JSON.toJSON(new Result("-1", ErrorMessage.NO_TOKEN)));
			return false;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//控制器执行之后
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//整个请求完成之后
	}

}
