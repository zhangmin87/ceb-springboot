package com.ceb.system.service.role;

import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.RoleDTO;


/**
 * @Author by zhangmin on 2018/9/7.16:20
 */
public interface RoleService {

    /**
     * @param pagination
     * @return
     */
    BootrapTablePaginationData<RoleDTO> getAllRole(Pagination pagination);
}
