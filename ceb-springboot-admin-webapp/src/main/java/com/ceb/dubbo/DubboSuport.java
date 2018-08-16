package com.ceb.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.system.service.User.UserService;


/**
 * @Author by zhangmin on 2018/8/15.14:32
 */
public class DubboSuport {

    @Reference
    public static  UserService userService;

}
