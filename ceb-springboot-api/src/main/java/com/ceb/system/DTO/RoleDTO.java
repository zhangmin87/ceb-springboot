package com.ceb.system.DTO;

import java.io.Serializable;

/**
 * @Author by zhangmin on 2018/9/7.16:43
 * <角色>
 */
public class RoleDTO implements Serializable {

    // 用户名
    private String rname;

    // type
    private String type:

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
