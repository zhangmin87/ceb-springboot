package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;

import com.ceb.system.DTO.StudentDTO;
import com.ceb.system.mapper.StudentMapper;
import com.ceb.system.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Service(interfaceClass = StudentService.class)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudent() {
        List<StudentDTO> students = studentMapper.get();
        return students;
//        return  null;
    }
}
