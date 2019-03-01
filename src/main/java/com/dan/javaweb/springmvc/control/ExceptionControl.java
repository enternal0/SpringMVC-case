package com.dan.javaweb.springmvc.control;

import com.dan.javaweb.springmvc.exception.MyGreetingException;
import com.dan.javaweb.springmvc.exception.MyUserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/exception")
@Controller
public class ExceptionControl {
    @RequestMapping(value = {"/user"},method = RequestMethod.GET)
    public String user(@RequestParam(value = "username")String username){
        if(username==null || username.length()==0){
            throw new MyUserException();
        }else {
//            它会去找username.jsp
            return username;
        }
    }
    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting(@RequestParam("username") String username){
        throw  new MyGreetingException(username+" 发生错误");
    }

    @ExceptionHandler(value = {MyGreetingException.class})
    @RequestMapping
    public ModelAndView greetingExceptionHandler(MyGreetingException e){
        String errorMessage=e.getMessage();
        ModelAndView modelAndView=new ModelAndView("errorGreeting");
        modelAndView.addObject("message",errorMessage);
        return modelAndView;
    }

}
