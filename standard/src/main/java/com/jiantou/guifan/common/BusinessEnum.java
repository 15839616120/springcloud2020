package com.jiantou.guifan.common;

public enum BusinessEnum {

    OK(0, "success"),
    Error(1, "failure"),
    PARAMETER_ISNULL(-102, "必填参数不能为空"),
    PARAMETER_FORMAT_ERROR(-103, "参数格式不正确"),
    PHONE_NULL(-104, "手机号不存在"),
    PHONE_EXIST(-105, "手机号已存在"),
    RECORD_NULL(-106,"手机号不存在释放记录");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    BusinessEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}