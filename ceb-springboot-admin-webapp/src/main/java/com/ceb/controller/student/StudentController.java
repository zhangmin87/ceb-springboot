package com.ceb.controller.student;


import com.alibaba.dubbo.config.annotation.Reference;


import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.service.User.UserService;
import com.ceb.system.service.student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/com/ceb")
public class StudentController {

    @Reference
    private StudentService studentService;

    @Reference
    private UserService userService;

    //初始化
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String inint() {
        return "Home";
    }

        //查询
    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public StudentDTO execute(Model  model ) {
        List<StudentDTO> list = studentService.getStudent();
        StudentDTO studentDTO = list.get(0);
        return  studentDTO;
    }
}