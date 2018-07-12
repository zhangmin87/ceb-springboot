package com.ceb.system.DTO;

/**
 * 学生类（测试）
 */
public class StudentDTO implements java.io.Serializable {

    //学生姓名
    private String name;

    //学生学号
    private Integer sno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }
}
