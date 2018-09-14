package com.ceb.system.service.role;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.14:42
 */
public interface RoleUserService {
    Set<String> getRoleUser(Long id);

    /**
     * 删除角色
     */
    void removeRoleByUser(Long userId);

    void saveRoleToUser(Long roleId,Long userId);
}
