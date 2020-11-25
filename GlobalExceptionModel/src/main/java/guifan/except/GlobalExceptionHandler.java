package guifan.except;

import guifan.common.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * controller 增强器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //slf4j日志处理
    public static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBean<?> errorHandler(Exception ex) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(500);
        resultBean.setMsg("全局异常捕捉处理");
        //将异常隐蔽，不让用户看到，然后后台以日志的形式记录起来，方便问题的查找
        //resultBean.setData(ex);
        log.error("全局异常捕捉处理",ex);
        return resultBean;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CheckException.class)
    public ResultBean<?> myErrorHandler(CheckException ex) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(500);
        resultBean.setMsg("自定义异常捕捉处理");
        //将异常隐蔽，不让用户看到，然后后台以日志的形式记录起来，方便问题的查找
        //resultBean.setData(ex);
        log.error("自定义异常捕捉处理",ex);
        return resultBean;
    }
}
