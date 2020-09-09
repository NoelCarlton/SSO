package com.noel.manifest.sso.auth_server.controller;

import com.noel.manifest.sso.auth_server.dao.UserDao;
import com.noel.manifest.sso.auth_server.model.RoleModel;
import com.noel.manifest.sso.auth_server.model.UserModel;
import com.noel.manifest.sso.auth_server.utils.UserRoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        Map<String, String> result = new HashMap<>();
        log.debug("注册...%s,%s", name, password);
        System.out.printf("注册...%s,%s", name, password);
        UserModel user = userDao.findUserModelByUsername(name);
        if(user!=null){
            result.put("error","用户已存在");
        }else {
            user = new UserModel();
            user.setUsername(name);
            user.setPassword(passwordEncoder.encode(password));
//            user.setPassword("123");
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            List<RoleModel> rs1 = new ArrayList<>();
            RoleModel r1 = new RoleModel();
            log.debug("用户角色是{}",UserRoleEnum.ROLE_ADMIN);
            r1.setName("ROLE_admin");
            r1.setNameZh("管理员");
            rs1.add(r1);
            user.setRoles(rs1);
            userDao.save(user);
            result.put("success", "register");
        }
        return result;
    }

}
