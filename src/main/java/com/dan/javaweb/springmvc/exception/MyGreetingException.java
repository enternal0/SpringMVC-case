package com.dan.javaweb.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "username参数异常")
public class MyGreetingException extends RuntimeException {
    public MyGreetingException(String message) {
       message=getMessage();
    }
}
