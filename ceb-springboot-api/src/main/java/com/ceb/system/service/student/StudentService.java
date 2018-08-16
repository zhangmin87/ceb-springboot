package com.ceb.system.service.student;

import com.ceb.system.DTO.StudentDTO;

import java.util.List;

public interface StudentService {

    /**
     * 获取学生信息
     * @return
     */
    List<StudentDTO> getStudent();
}
