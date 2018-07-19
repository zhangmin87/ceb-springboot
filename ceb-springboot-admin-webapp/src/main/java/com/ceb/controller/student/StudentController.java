package com.ceb.controller.student;


import com.alibaba.dubbo.config.annotation.Reference;


import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/com/ceb")
public class StudentController {
    @Reference
    private StudentService studentService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public Model execute(Model model) {
       StudentDTO studentDTO = studentService.getStudent();
       return  model;
    }
}