package com.noel.manifest.sso.auth_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @Description
 * @Author noel
 * @Date 2020/8/21
 * Version 1.0
 **/
@Controller
public class IndexController {

    @GetMapping("/user")
    @ResponseBody
    public Principal index(Principal principal){
        return principal;
    }

    @GetMapping("/docheck")
    public String check(){
        return "check";
    }
}
