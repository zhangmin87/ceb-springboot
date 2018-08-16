package com.ceb.controller.login;

import com.ceb.common.TokenMannagerfacadeHelper;
import com.ceb.controller.AdminController;
import com.ceb.shiro.DTO.UUser;

import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/login")
public class ResourceLoginController extends AdminController {
    /**
     * 初始化
     * @param model
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String execute(Model  model ) {
        UUser user = new UUser();
        model.addAttribute("UUser",user);
        return  "login" ;
    }

    /**
     * 登录
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "toLogin",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> login(UUser uUser, boolean rememberMe) {
        try {
            TokenMannagerfacadeHelper.login(uUser,rememberMe);
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
        }catch (DisabledAccountException e) {
            resultMap.put("status",500);
            resultMap.put("message","账号禁用");
        }catch (Exception e) {
            resultMap.put("status",500);
            resultMap.put("message","账号或者密码错误");
        }
        return  resultMap;
    }

}