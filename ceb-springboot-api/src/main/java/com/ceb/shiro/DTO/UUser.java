package com.ceb.shiro.DTO;

import java.io.Serializable;
import java.util.Date;

public class UUser implements Serializable {

    private static final long serialVersionUID = 1L;

    //禁止登录
    public static final Long _0 = new Long(0);

    //1.有效
    public static final Long _1 = new Long(1);
    private Long id;
    //昵称
    private String nickname;
    //邮箱
    private String email;
    //Fixme 密码 transient 不进行网络传输不进行序列化(这里先删除)
    private  String pswd;
    /** 创建时间*/
    private Date createTime;
    /** 最后登录时间 */
    private Date lastLoginTime;
    /**1:有效  ,0 禁止登录*/
    private Long status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static Long get_0() {
        return _0;
    }

    public static Long get_1() {
        return _1;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

