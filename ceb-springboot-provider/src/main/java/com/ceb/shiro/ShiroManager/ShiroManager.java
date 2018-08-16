package com.ceb.shiro.ShiroManager;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.common.INI4j;
import com.ceb.system.service.ShiroManager.ShiroManagerService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @Author by zhangmin on 2018/8/3.9:35
 * 解析inni 文件(固定角色)
 */
@Component
@Service(interfaceClass = ShiroManagerService.class)
public class ShiroManager implements ShiroManagerService {

    @Override
    public String loadFilterChainDefinitions() {
        StringBuffer sb = new StringBuffer();
        sb.append(getFixedAuthRole());
        return sb.toString();
    }

    private String getFixedAuthRole() {
        String fileName = "shiro_base_auth.ini";
        ClassPathResource cp = new ClassPathResource(fileName);
        INI4j ini = null;
        try {
            ini = new INI4j(cp.getFile());
            // TODO: 2018/8/3 目前现在先用exception 代替一下
        } catch (Exception e) {
            // TODO:
        }
        String section = "base_auth";
        Set<String> keys = ini.get(section).keySet();
        StringBuffer sb = new StringBuffer();
        for (String key : keys) {
            String value = ini.get(section, key);
            sb.append(key).append(" = ")
                    .append(value).append("\r\n");
        }
        return sb.toString();

    }

}
