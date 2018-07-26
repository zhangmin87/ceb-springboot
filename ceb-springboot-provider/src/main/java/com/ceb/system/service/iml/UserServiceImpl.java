package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.exterior.encoder.MD5TextEncoder;
import com.ceb.exterior.encoder.TextEncoder;
import com.ceb.system.DTO.UserDTO;
import com.ceb.system.mapper.login.LoginMapper;
import com.ceb.system.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 如果既需要spring注入又需要当做provider ，不能同时使用这两个service,
 * 因为同名不能import ,真要用的话，spring的那个可以换成@component
 *
 */
@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginMapper logionMapper;

    TextEncoder textEncoder = new MD5TextEncoder();

    @Override
    public void doSave(UserDTO userDTO) {
        String encodedPasswd = textEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPasswd);
        logionMapper.insertUser(userDTO);
    }
}
