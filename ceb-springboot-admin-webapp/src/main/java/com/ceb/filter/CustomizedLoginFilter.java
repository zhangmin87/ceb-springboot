package com.ceb.filter;

import com.ceb.common.TokenManager;
import com.ceb.shiro.DTO.UUser;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author by zhangmin on 2018/8/19.8:04
 * 定义loginFilter
 */
public class CustomizedLoginFilter extends AccessControlFilter {
    final static Class<CustomizedLoginFilter> CLASS = CustomizedLoginFilter.class;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        UUser uUser = TokenManager.getToken();
        if(null != uUser || isLoginRequest(servletRequest, servletResponse)) {// && isEnabled()
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //保存Request和Response 到登录后的链接
        Subject subject = getSubject(servletRequest ,servletResponse);
        //没有登录直接跳转到登录页面
        if (null == subject.getPrincipal()) {
            saveRequest(servletRequest);
            WebUtils.issueRedirect(servletRequest,servletResponse,"com/ceb");
        }
        saveRequestAndRedirectToLogin(servletRequest, servletResponse);
        return Boolean.FALSE ;
    }
}
