package com.noel.sso.client_register.controller;

import com.noel.sso.client_register.dao.ClientDetailsDao;
import com.noel.sso.client_register.model.ClientDetailsModel;
import com.noel.sso.client_register.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/11
 * Version 1.0
 **/
@Controller
public class RegisterController {

    @Autowired
    ClientDetailsDao clientDetailsDao;

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
    @ResponseBody
    public Result doRegister(
            @RequestParam("secret")String secret,
            @RequestParam("resource_id")String resourceId,
            @RequestParam("scope")String scope,
            @RequestParam("grant_types")String grantType,
            @RequestParam("redirect_uri")String redirectUri,
            @RequestParam(value = "auto_approve", required = false)String autoApprove
    ){
        ClientDetailsModel client = new ClientDetailsModel();
        System.out.println("clientId = [], secret = [" + secret + "], resourceId = [" + resourceId + "], scope = [" + scope + "], grantType = [" + grantType + "], redirectUri = [" + redirectUri + "]");
        client.setClient_secret(new BCryptPasswordEncoder().encode(secret));
        client.setResource_ids(resourceId);
        client.setScope(scope);
        client.setAuthorized_grant_types(grantType);
        client.setWeb_server_redirect_uri(redirectUri);
        client.setAutoapprove(autoApprove==null?"true":autoApprove);
        ClientDetailsModel clientDetailsModel = clientDetailsDao.save(client);
        System.out.println(clientDetailsModel.toString());
        return Result.ok().data("info",clientDetailsModel);
    }
}
