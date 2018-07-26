package com.ceb.controller.login;



import com.alibaba.dubbo.config.annotation.Reference;
import com.ceb.system.DTO.UserDTO;
import com.ceb.system.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class ResourceLoginController {

    @Reference
    private UserService userService;

    //查询
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String execute(Model  model ) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO",userDTO);
        return  "login" ;
    }

    @RequestMapping(value = "register",method = {RequestMethod.GET,RequestMethod.POST})
    public String login( UserDTO userDTO, Model model) {
        userService.doSave(userDTO);
        return "login";
    }
}