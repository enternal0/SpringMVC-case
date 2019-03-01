package com.dan.javaweb.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;
@Controller
public class UploadControl {

    @RequestMapping(value = "/upload",method = {RequestMethod.GET})
    public ModelAndView upload(){
        return new ModelAndView("upload");
    }
    @RequestMapping(value = {"/upload"},method = {RequestMethod.POST})
    public ModelAndView upload(@RequestPart(value = "head") MultipartFile multipartFile){
        ModelAndView modelAndView=new ModelAndView();
        try {
            byte[] bytes=multipartFile.getBytes();
            String value=Base64.getEncoder().encodeToString(bytes);
            String filename=multipartFile.getOriginalFilename();
//            取图片的后缀
            String extend=filename.substring(filename.lastIndexOf('.')+1);
            String base64Value=String.format("data:image/%s;base64,%s",extend,value);
            modelAndView.addObject("head_data",base64Value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("upload");
        return modelAndView;
    }
}
