package com.ceb.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.controller.AdminController;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author by zhangmin on 2018/8/20.15:49
 */
@Controller
@RequestMapping("/com/user")
public class ResourceUserController extends AdminController {

    @Reference
    private UserService userService;

    //初始化
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String init(Model model) {
        return "user/userDetail";
    }

    //初始化
    @RequestMapping(value = "/detail",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<UUser> execute(Model model) {
        List<UUser> list = userService.getAllUser();
        return list;
    }
}
