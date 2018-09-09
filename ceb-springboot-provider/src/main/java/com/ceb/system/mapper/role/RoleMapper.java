package com.ceb.system.mapper.role;

import com.ceb.system.DTO.RoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @Author by zhangmin on 2018/9/7.17:38
 */
@Mapper
public interface RoleMapper {
    List<RoleDTO> selectRole();
}
