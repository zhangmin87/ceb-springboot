package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.BaseServiceImpl;
import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.system.DTO.RoleDTO;
import com.ceb.system.mapper.role.RoleMapper;
import com.ceb.system.mapper.role.RoleUserMapper;
import com.ceb.system.service.role.RoleService;
import com.github.pagehelper.ISelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author by zhangmin on 2018/9/7.16:52
 */
@Component
@Service(interfaceClass = RoleService.class)
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public BootrapTablePaginationData<RoleDTO> getAllRole(Pagination pagination) {
       List<RoleDTO> result = executeQuery(pagination, new ISelect() {
            @Override
            public void doSelect() {
                roleMapper.selectRole();
            }
        });
        // 封装成boostrap 分页对象
        return new BootrapTablePaginationData<>(pagination,result);
    }


}
