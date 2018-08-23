package com.ceb.conirgution;


import com.ceb.controller.student.SampleRealm;
import com.ceb.dubbo.DubboSuport;
import com.ceb.filter.CustomizedAjaxFilter;
import com.ceb.filter.CustomizedLoginFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;


import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author by zhangmin on 2018/8/3.9:26
 * shiro  配置
 */
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //自定义拦截器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("customizeAjax",new CustomizedAjaxFilter());
        filters.put("customizedLogin",new CustomizedLoginFilter());
        shiroFilterFactoryBean.setFilters(filters);

        /**
         * 这里利用shiro 中默认拦截器 如:'anon' 会有有匿名拦截器 AnonymousFilter
         * authc 对应拦截器 AuthenticationFilter 具体参考博客 https://www.cnblogs.com/litblank/p/7883167.html
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/user/toLogin","customizedLogin");
        filterChainDefinitionMap.put("/com/ceb/query","customizeAjax");
        filterChainDefinitionMap.put("/com/ceb/**","authc");
        //没有登录的用户请求需要登录的页面时自动跳转到登录页面，不是必须的属性
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("sessionManager")SessionManager sessionManager ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        SampleRealm sampleRealm = new SampleRealm();
        securityManager.setSessionManager(sessionManager);
        securityManager.setRealm(sampleRealm);
        securityManager.setSessionManager(sessionManager);
        //todo:此功能暂时不加
        //        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }

    @Bean(name = "delegatingFilterProxy")
    public FilterRegistrationBean delegatingFilterProxy() {
         FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
         DelegatingFilterProxy proxy = new DelegatingFilterProxy();
         proxy.setTargetFilterLifecycle(true);
         proxy.setTargetBeanName("shiroFilter");
         filterRegistrationBean.setFilter(proxy);
         return filterRegistrationBean;
    }

    @Bean
    public static DubboSuport getDubboSupport() {
        DubboSuport dubboSuport = new DubboSuport();
        return dubboSuport;
    }

    @Bean
    public SampleRealm shiroRealm() {
        SampleRealm shiroRealm = new SampleRealm(getDubboSupport());
        return shiroRealm;
    }

    /**
     * sessionManager
     */
    @Bean(name = "sessionManager")
    public SessionManager getSessionManager() {
        //todo:这里暂时配置使用默认的
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        //session 过期时间
        defaultWebSessionManager.setGlobalSessionTimeout(10000);
        //删除失败的session
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        return defaultWebSessionManager;
    }

//
//    @Bean
//    public SimpleCookie rememberMeCookie() {
//        SimpleCookie simpleCookie = new SimpleCookie();
//        //httpOnly为true的时候,防止前端js 获取到cookie 信息
//        simpleCookie.setHttpOnly(true);
//        //设置cookie的名字
//        simpleCookie.setName("v_v_re_apple");
//        //设置ocokis的过期的时间
//        simpleCookie.setMaxAge(1800000);
//        return simpleCookie;
//    }

    //remember
//    @Bean
//    public CookieRememberMeManager cookieRememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie simpleCookie ) {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCipherKey(Base64.decode("AvVhmFLUs0KTA3Kprsdag=="));
//        cookieRememberMeManager.setCookie(simpleCookie);
//        return cookieRememberMeManager;
//    }
}
