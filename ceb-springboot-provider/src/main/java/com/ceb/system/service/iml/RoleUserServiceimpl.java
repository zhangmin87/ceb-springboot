package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.system.mapper.role.RoleUserMapper;
import com.ceb.system.service.role.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.14:51
 */
@Component
@Service(interfaceClass = RoleUserService.class)
public class RoleUserServiceimpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public Set<String> getRoleUser(Long id) {
        return roleUserMapper.selectRoleByUserId(id);
    }

    @Override
    public void removeRoleByUser(Long userId ) {
        roleUserMapper.deleteRoleByUserId(userId);
    }

    @Override
    public void saveRoleToUser(Long roleId, Long userId) {
       roleUserMapper.insertRole(roleId,userId);
    }
}

