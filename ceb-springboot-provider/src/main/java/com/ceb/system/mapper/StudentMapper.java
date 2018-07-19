package com.ceb.system.mapper;

import com.ceb.system.DTO.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

public interface StudentMapper {
    List<StudentDTO> get();
}
