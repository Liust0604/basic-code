package com.mori.course02.demoexception.exception;

/**
 * 自定义异常类
 * 1、继承Exception/RuntimeException
 */

public class RegisterException extends Exception {

    //2、一个空参构造方法
    public RegisterException() {
        super();
    }

    //3、一个带异常信息的构造方法,
    public RegisterException(String message) {
        super(message);
    }
}
