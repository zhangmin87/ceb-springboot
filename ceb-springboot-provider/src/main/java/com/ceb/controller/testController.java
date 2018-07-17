package com.ceb.controller;

import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/ma")
public class testController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public StudentDTO  execute(Model  model) {
       StudentDTO studentDTO = studentService.getStudent();
       return studentDTO ;
    }
}
