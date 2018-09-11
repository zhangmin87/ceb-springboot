package com.ceb.system.mapper.user;

import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(UserDTO userDTO);

    /**
     * 获取用户信息
     * @param email
     * @param pswd
     * @return
     */
    UUser selectUserByEmailAndPwd(@Param("email")String email,@Param("pswd")String pswd);

    /**
     * 更新用户信息
     * @param uUser
     */
    void updateUser(UUser uUser);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UUser> selectUser();

}
