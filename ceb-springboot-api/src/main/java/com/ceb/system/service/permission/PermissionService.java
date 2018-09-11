package com.ceb.system.service.permission;

import java.util.Set;

/**
 * @Author by zhangmin on 2018/9/10.16:02
 */
public interface PermissionService {

    Set<String> findPermissionByUserId(Long userId);
}
