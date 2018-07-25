package com.ceb.controller.login;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/com/ceb")
public class RessourceLoginController {

    //查询
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String execute(Model  model ) {
        return  "login" ;
    }

}