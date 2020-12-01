package org.dkwork.javatemplate.common.domain;

public enum Status {

    //异常
    ERROR_SYSTEM(9000, "系统异常"),//显式捕捉异常
    ERROR_ADVICE(9001, "运行异常"),//切面捕捉异常
    ERROR_OTHER(9002, "外部异常"),//外部系统异常
    ERROR_REQUEST_PARAMETER(9003, "请求参数错误"),

    INVALID_HANDLE_CODE(9004, "办件校验失败，请重新提交！"),

    // 公共
    SUCCESS(1000, "成功"),
    WARN(1001, "失败"),//无exception

    // 登录
    LOGIN_EXPIRE(2001, "未登录或者登录失效"),
    LOGIN_CODE_ERROR(2002, "登录验证码错误"),
    LOGIN_ERROR(2003, "用户名不存在或密码错误"),
    LOGIN_USER_STATUS_ERROR(2004, "用户状态不正确"),
    LOGOUT_ERROR(2005, "退出失败，token不存在"),
    LOGIN_USER_NOT_EXIST(2006, "该用户不存在"),
    LOGIN_USER_EXIST(2007, "该用户已存在"),

    PERMISSION_INSUFFICIENT(2008, "权限不足"),

    LOGIN_ACCESS_DENY(2009, "拒绝访问");


    public int code;
    public String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
