package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.system.mapper.StudentMapper;

import com.ceb.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


;


@Component
@Service(interfaceClass = StudentService.class)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public String getStudent() {
        String student =  mapper.select();
        return student;
    }
}