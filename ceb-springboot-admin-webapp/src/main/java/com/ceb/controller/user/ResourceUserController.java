package com.ceb.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.controller.AdminController;
import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.service.User.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author by zhangmin on 2018/8/20.15:49
 */
@Controller
@RequestMapping("/com/user")
public class ResourceUserController extends AdminController {

    @Reference
    private UserService userService;

    // 初始化
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String init(Model model) {
        return "user/userDetail";
    }

    // 用户细节
    @RequestMapping(value = "/detail",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BootrapTablePaginationData execute(Pagination pagination) {
        BootrapTablePaginationData<UUser> p = userService.getAllUser(pagination);
        //FIXME:适用bootstrap 分页
        return p;
    }
}
