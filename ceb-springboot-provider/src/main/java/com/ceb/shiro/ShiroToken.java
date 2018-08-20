package com.ceb.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * token 扩展父类中的password 用字符串类型
 */
public class ShiroToken extends UsernamePasswordToken implements java.io.Serializable {

    private static final long serialVersionUID = -6451794657814516274L;

    public ShiroToken(String username, String password) {
        super(username, password);
        this.pwd = password;
    }
    //登录密码、字符串，因为父类是插入
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}