package com.ceb.common;

import com.ceb.shiro.DTO.UUser;
import com.ceb.shiro.ShiroToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author by zhangmin on 2018/8/14.19:21
 */
public class TokenMannagerfacadeHelper {

    /**
     * 登录
     * @param uUser 用户
     * @param rememberme 记住我
     * @return
     */
    public static UUser login(UUser uUser, boolean rememberme) {
        UsernamePasswordToken shiroToken = new ShiroToken(uUser.getEmail(),uUser.getPswd());
        shiroToken.setRememberMe(rememberme);
        SecurityUtils.getSubject().login(shiroToken);
        return getToken();
    }

    /**
     * 获取当前登录的用户user对象
     * @return
     */
    public static UUser getToken() {
        UUser uUser = (UUser)SecurityUtils.getSubject().getPrincipal();
        return uUser;
    }
}
