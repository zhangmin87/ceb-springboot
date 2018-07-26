package com.ceb.system.mapper.login;

import com.ceb.system.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    void insertUser(UserDTO userDTO);
}
