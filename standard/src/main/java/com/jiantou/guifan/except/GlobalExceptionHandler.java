package com.jiantou.guifan.except;

import com.jiantou.guifan.common.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类
 * controller 增强器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean<?> errorHandler(Exception ex) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(500);
        resultBean.setMsg("全局异常捕捉处理");
        resultBean.setData(ex);
        return resultBean;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CheckException.class)
    public ResultBean<?> myErrorHandler(CheckException ex) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(500);
        resultBean.setMsg("拦截捕捉自定义异常");
        resultBean.setData(ex);
        return resultBean;
    }
}
