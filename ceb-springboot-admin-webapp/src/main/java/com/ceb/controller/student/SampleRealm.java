package com.ceb.controller.student;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.dubbo.DubboSuport;
import com.ceb.shiro.DTO.UUser;
import com.ceb.shiro.ShiroToken;
import com.ceb.system.service.User.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Date;


/**
 * @Author by zhangmin on 2018/8/2.9:19
 *
 * <p>
 *  此类用户数据库交互的信息
 * </p>
 */
public class SampleRealm extends AuthorizingRealm {
//    @Reference
//    @Lazy
//    private UserService userService;

//    @Autowired
    /**
     * fixme ：由于SamleReam 底层是拦截器 类加载顺序有问题 ,导致dubbo 服务无法成功注入通过@reference 注入进来，所有是有问题的，通过另外一个类吗，注入进去，，然后通过构造器的方式进来，后期有时间研究一下
     *
     *
     */
    private DubboSuport dubboSuport;

    public SampleRealm(DubboSuport dubboSuport) {
        this.dubboSuport = dubboSuport;
    }

    public SampleRealm() {
        super();
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
          ShiroToken shiroToken = (ShiroToken) authenticationToken;
          UUser uUser =  DubboSuport.userService.getUser(shiroToken.getUsername(),shiroToken.getPwd());
          if (uUser == null) {
            throw new AccountException("帐号或密码不正确！");
        }else if (UUser._0.equals(uUser.getStatus())) {
            throw new DisabledAccountException("此账号已经禁止登录");
        }else {
            //更新登录时间
            uUser.setLastLoginTime(new Date());
            DubboSuport.userService.updateUser(uUser);
        }
        //返回认证信息，由AuthorizingRealm 完成认证
        return new SimpleAuthenticationInfo(uUser,uUser.getPswd(),getName());
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
