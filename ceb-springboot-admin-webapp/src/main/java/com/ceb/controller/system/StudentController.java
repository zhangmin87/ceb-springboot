package com.ceb.controller.system;


import com.alibaba.dubbo.config.annotation.Reference;


import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/com/ceb")
public class StudentController {

    @Reference
    private StudentService studentService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public List<StudentDTO> execute() {
        List<StudentDTO> list = studentService.getStudent();
       return  list;
    }
}