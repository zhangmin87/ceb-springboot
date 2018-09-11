package com.ceb.system.mapper.role;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.14:01
 */
@Mapper
public interface RoleUserMapper {

    Set<String> selectRoleByUserId(Long Id);
}
