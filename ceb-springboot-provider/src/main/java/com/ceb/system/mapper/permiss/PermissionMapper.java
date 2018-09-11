package com.ceb.system.mapper.permiss;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.16:10
 */
@Mapper
public interface PermissionMapper {

    //根据用户Id查询权限（permission）,放入到Authorization里
    Set<String> selectPermissionByUserId(Long userId);
}

