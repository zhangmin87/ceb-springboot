package com.ceb.system.mapper;

import com.ceb.system.DTO.StudentDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDTO> get();
}
