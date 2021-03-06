package com.ceb.controller.role;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.controller.AdminController;
import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.RoleDTO;
import com.ceb.system.service.role.RoleService;
import com.ceb.system.service.role.RoleUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author by zhangmin on 2018/9/9.7:15
 */
@Controller
@RequestMapping("/com/role")
public class RoleResoureController extends AdminController {

    @Reference
    private RoleService roleService;

    @Reference
    private RoleUserService roleUserService;
    /**
     * 初始化
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String init() {
        return "role/roleDetail";
    }

    /**
     *详细信息
     * @param pagination
     * @return
     */
    @RequestMapping(value = "/detail.json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BootrapTablePaginationData execute(Pagination  pagination) {

        BootrapTablePaginationData<RoleDTO> bootrapTablePaginationData = roleService.getAllRole(pagination);

        return bootrapTablePaginationData;
    }


    /**
     * 赋角色
     * @param
     */
    @RequestMapping(value = "/addRole",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void addRole(@RequestParam("checkboxArr") Long[] checkboxArr,@RequestParam("userId") Long userId) {
        // 先删除所有权限
        roleUserService.removeRoleByUser(((UUser)SecurityUtils.getSubject().getPrincipal()).getId());
        //todo: 校验
        // 保存
        for (Long roleId:checkboxArr) {
            roleUserService.saveRoleToUser(roleId,((UUser)SecurityUtils.getSubject().getPrincipal()).getId());
        }
    }

}
