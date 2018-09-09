package com.ceb.controller.role;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.controller.AdminController;
import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.system.DTO.RoleDTO;
import com.ceb.system.service.role.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author by zhangmin on 2018/9/9.7:15
 */
@Controller
@RequestMapping("/com/role")
public class RoleResoureController extends AdminController {

    @Reference
    private RoleService roleService;

    /**
     * 初始化
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String init() {
        return "role/roleDetail";
    }

    @RequestMapping(value = "/detail.json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BootrapTablePaginationData execute(Pagination  pagination) {
        BootrapTablePaginationData<RoleDTO> bootrapTablePaginationData = roleService.getAllRole(pagination);
        return bootrapTablePaginationData;
    }
}
