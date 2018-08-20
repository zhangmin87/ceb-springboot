package com.ceb.common;

import com.ceb.controller.student.SampleRealm;
import com.ceb.shiro.DTO.UUser;
import org.apache.shiro.SecurityUtils;
import org.thymeleaf.spring5.context.SpringContextUtils;

/**
 * @Author by zhangmin on 2018/8/19.8:55
 */
public class TokenManager {

    //用户管理
//    public static final SampleRealm realm = SpringContextUtil.getBean("sampleRealm",SampleRealm.class);

    //用户session 管理

    public static UUser getToken() {
        UUser token =(UUser) SecurityUtils.getSubject().getPrincipal();
        return token;
    }
}
