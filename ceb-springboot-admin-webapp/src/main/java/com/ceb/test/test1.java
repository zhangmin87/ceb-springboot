package com.ceb.test;

import com.ceb.system.DTO.StudentDTO;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author by zhangmin on 2018/8/22.9:48
 */
public class test1 {
    public static void main(String[] args) {
        StudentDTO studentDTO = new StudentDTO();
        Map<String ,StudentDTO> stringStudentDTOMap = new HashMap<>();
        studentDTO.setName("zhang");
        studentDTO.setSno(1);
        stringStudentDTOMap.put("nihao",studentDTO);
        System.out.println(studentDTO.toString());
    }
}
