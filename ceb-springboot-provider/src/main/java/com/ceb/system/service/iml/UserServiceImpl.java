package com.ceb.system.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.ceb.BaseServiceImpl;
import com.ceb.exterior.encoder.MD5TextEncoder;
import com.ceb.exterior.encoder.TextEncoder;
import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.UserDTO;
import com.ceb.system.mapper.user.UserMapper;
import com.ceb.system.service.User.UserService;
import com.github.pagehelper.ISelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * 如果既需要spring注入又需要当做provider ，不能同时使用这两个service,
 * 因为同名不能import ,真要用的话，spring的那个可以换成@component
 *
 */
@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl extends BaseServiceImpl implements UserService {


    @Autowired
    private UserMapper logionMapper;

    TextEncoder textEncoder = new MD5TextEncoder();

    @Override
    public void doSave(UserDTO userDTO) {
        String encodedPasswd = textEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPasswd);
        userDTO.setCreateTime(new Date());
        logionMapper.insertUser(userDTO);
    }

    @Override
    public UUser getUser(String email, String pswd) {
        UUser uUser = logionMapper.selectUserByEmailAndPswd(email,pswd);
        return uUser;
    }

    @Override
    public void updateUser(UUser uUser) {
        logionMapper.updateUser(uUser);
    }

    @Override
    public BootrapTablePaginationData<UUser> getAllUser(Pagination pagination) {

       // 分页查询出来的数据
       List<UUser> result = executeQuery(pagination, new ISelect() {
            @Override
            public void doSelect() {
                logionMapper.selectUser();
            }
        });
       // 封装成boostrap 分页对象
       return new BootrapTablePaginationData<>(pagination.getTotalCount(),result);
    }
}
