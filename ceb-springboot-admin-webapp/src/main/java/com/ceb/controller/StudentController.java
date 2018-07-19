package com.ceb.controller;


import com.alibaba.dubbo.config.annotation.Reference;


import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/ceb")
public class StudentController {

    @Reference
    private StudentService studentService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public StudentDTO execute() {
       StudentDTO studentDTO = studentService.getStudent();
       return  studentDTO;
    }
}