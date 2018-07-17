package com.ceb.system.mapper;

import com.ceb.system.DTO.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

public interface StudentMapper {
    StudentDTO get();
}
