package com.dan.javaweb.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class HelloWorldControler {
    public static String user;

    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
       modelAndView.addObject("datetime","现在时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date()));
        return modelAndView;
    }
    @RequestMapping(value = "login",method = {RequestMethod.GET})
    public ModelAndView login(){
        ModelAndView modelAndVie=new ModelAndView("login");
        return modelAndVie;
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        user=request.getParameter("username");
        try {
            user=new String(user.getBytes("ISO-8859-1"),"UTF-8");
            HttpSession httpSession=request.getSession();
            httpSession.setAttribute("username",user);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String password=request.getParameter("password");
//        把login执行完之后会回到home页面
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("username",user);
        return modelAndView;
    }
}
