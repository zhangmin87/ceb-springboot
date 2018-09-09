package com.ceb.system.DTO;

import java.io.Serializable;

/**
 * @Author by zhangmin on 2018/9/7.16:43
 * <角色>
 */
public class RoleDTO implements Serializable {

    //id
    private String id;

    // 用户名
    private String name;

    // type
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
