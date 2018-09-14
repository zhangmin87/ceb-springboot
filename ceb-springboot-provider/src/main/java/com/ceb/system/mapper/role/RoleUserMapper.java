package com.ceb.system.mapper.role;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.14:01
 */
@Mapper
public interface RoleUserMapper {

    /**
     * 根据用户ID获取角色信息
     * @param Id
     * @return
     */
    Set<String> selectRoleByUserId(Long Id);

    /**
     * 根据用户ID删除角色信息
     */
    void deleteRoleByUserId(Long id);

    /**
     * 增添角色
     * @param userId
     * @param roleId
     */
    void insertRole(Long userId,Long roleId);
}
