package com.noel.manifest.sso.auth_server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author noel
 * @Date 2020/8/21
 * Version 1.0
 **/
@Controller
public class IndexController {

    public static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/user")
    @ResponseBody
    public Principal index(Principal principal) {
        return principal;
    }

    @GetMapping("/docheck")
    public String check() {
        log.debug("登入...");
        System.out.println("登入.....");
        return "check";
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String, String> register(@RequestParam("username") String name,
                           @RequestParam("password") String password) {
        log.debug("注册...%s,%s", name, password);
        System.out.printf("注册...%s,%s", name, password);
        Map<String, String> result = new HashMap<>();
        result.put("success", "register");
        return result;
    }

}
