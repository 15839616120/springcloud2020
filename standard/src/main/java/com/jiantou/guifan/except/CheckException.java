package com.jiantou.guifan.except;

/**
 * 自定义异常，主要作用处理校验参数
 */
public class CheckException extends RuntimeException {
    private String code;
    private String msg;
    public CheckException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
