package com.ceb.system.mapper.login;

import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.UserDTO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    void insertUser(UserDTO userDTO);

    /**
     * 获取用户信息
     * @param email
     * @param pswd
     * @return
     */
    UUser selectUser(@Param("email")String email,@Param("pswd")String pswd);

    /**
     * 更新用户信息
     * @param uUser
     */
    void updateUser(UUser uUser);
}
