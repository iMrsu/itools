package com.miaoc.itools.utils.system;

import com.miaoc.itools.utils.entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2019-08-24 15:23
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常处理
     */
    @ExceptionHandler
    @ResponseBody
    public Result handleException(HttpServletRequest request, HttpServletResponse response, final Exception e) {
        LOG.error(e.getMessage(), e);
        Result result = new Result();
        result.setCode(1);

        result.setMsg(e.getMessage() != null ? e.getMessage() : "");
        //如果是业务逻辑异常，返回具体的错误码与提示信息
        if (e instanceof ServiceException) {//可以在前端Alert的异常
            ServiceException logicException = (ServiceException) e;
            result.setErrorCode(logicException.getCode()+"");
            result.setMsg(logicException.getMessage());
                return result;
        } else {//其它异常
            return result;
        }
    }

}