package com.noel.sso.client_register.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/11
 * Version 1.0
 **/
@Controller
public class RegisterController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + Arrays.toString(authentication.getAuthorities().toArray());
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(
            @RequestParam("client_id")String clientId,
            @RequestParam("secret")String secret,
            @RequestParam("resource_id")String resourceId,
            @RequestParam("scope")String scope,
            @RequestParam("grant_types")String grantType,
            @RequestParam("redirect_uri")String redirectUri
    ){
        return "success";
    }
}
