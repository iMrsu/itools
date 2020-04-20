package com.miaoc.itools;

import com.miaoc.itools.utils.interceptor.ControllerInterceptor;
import com.miaoc.itools.utils.interceptor.TimeInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = {"com"})
@MapperScan(basePackages = { "com.miaoc.itools.*" })
public class ItoolsApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ItoolsApplication.class, args);
    }

    @Resource(name = "tokenInterceptor")
    private HandlerInterceptor tokenInterceptor;
    @Autowired
    TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器
        registry.addInterceptor(new ControllerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/error");
        registry.addInterceptor(tokenInterceptor) // token拦截器
                .addPathPatterns("/**")
                .excludePathPatterns("/login") // 登陆API
                .excludePathPatterns("/views/**/*") // PC页面视图相关
                .excludePathPatterns("/views/*")
                .excludePathPatterns("/views")
                .excludePathPatterns("/error");
        registry.addInterceptor(timeInterceptor); // timeInterceptor注册
        super.addInterceptors(registry);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*") // 允许跨域请求
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
