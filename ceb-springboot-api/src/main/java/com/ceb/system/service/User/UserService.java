package com.ceb.system.service.User;

import com.ceb.exterior.page.BootrapTablePaginationData;
import com.ceb.exterior.page.Pagination;
import com.ceb.shiro.DTO.UUser;
import com.ceb.system.DTO.UserDTO;


public interface UserService {

    void doSave(UserDTO userDTO);

    UUser getUser(String email,String pswd);

    void updateUser(UUser uUser);

    BootrapTablePaginationData<UUser> getAllUser(Pagination pagination);
}
