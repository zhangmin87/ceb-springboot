package com.ceb.conirgution;

import com.ceb.controller.student.SampleRealm;
import com.ceb.dubbo.DubboSuport;
import com.ceb.system.service.User.UserService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author by zhangmin on 2018/8/3.9:26
 * shiro  配置
 */
@Configuration
public class ShiroConfig {
//    @Bean(name="shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(ShiroManagerService shiroManagerService) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
////        shiroFilterFactoryBean.setFilterChainDefinitions(shiroManagerService.loadFilterChainDefinitions());
//        DefaultWebSecurityManager  defaultWebSecurityManager = new DefaultWebSecurityManager();
//        SampleRealm sampleRealm = new SampleRealm();
//        defaultWebSecurityManager.setRealm(sampleRealm);
//
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//        //拦截器
//        // ;
//        Map<String,String> filterChainDeinitionMap = new LinkedHashMap<String,String>();
//        filterChainDeinitionMap.put("/login/toLogin","anon");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDeinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean delegatingFilterProxy(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        proxy.setTargetFilterLifecycle(true);
//        filterRegistrationBean.setFilter(proxy);
//        return filterRegistrationBean;
//    }

//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
//        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//        return filterFactoryBean;
//    }


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //filterChainDefinitionMap.put("/page/*", "authc");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //filterChainDefinitionMap.put("/security/logoff", "logout");
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        SampleRealm sampleRealm = new SampleRealm();
        securityManager.setRealm(sampleRealm);
        return securityManager;
    }

    @Bean(name = "delegatingFilterProxy")
    public FilterRegistrationBean delegatingFilterProxy(){
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
}
