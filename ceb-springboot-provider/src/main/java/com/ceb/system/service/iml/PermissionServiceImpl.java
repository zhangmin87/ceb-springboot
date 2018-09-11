package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.BaseServiceImpl;
import com.ceb.system.mapper.permiss.PermissionMapper;
import com.ceb.system.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.16:02
 * 根据用户id 查找相应的权限
 */
@Component
@Service(interfaceClass = PermissionService.class)
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户ID 查询相应的权限
     * @param userId
     * @return
     */
    @Override
    public Set<String> findPermissionByUserId(Long userId) {
        Set<String> strings = permissionMapper.selectPermissionByUserId(userId);
        return strings;
    }
}
