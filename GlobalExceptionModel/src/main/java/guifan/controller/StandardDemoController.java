package guifan.controller;


import guifan.except.CheckException;
import guifan.except.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardDemoController {

    //slf4j日志处理
    public static Logger log = LoggerFactory.getLogger(StandardDemoController.class);

    /**
     * 测试全局异常处理
     * @return
     * @throws Exception
     */
    @RequestMapping("/home")
    public String home1() throws Exception {
        //自定义异常捕捉处理
        //throw new CheckException("101", "Sam 错误");
        //全局异常捕捉处理
       /* RuntimeException runtimeException = new RuntimeException();
        throw runtimeException;*/
       //全局异常捕捉处理
        //throw new Exception();
        //全局异常捕捉处理
        throw  new NullPointerException();

    }

    /**
     * 测试日志级别
     * @return
     */
    @RequestMapping("/testLogLevel")
    public String testLogLevel(){
        log.error("error");
        log.info("info");
        log.debug("debug");
        return null;
    }
}
