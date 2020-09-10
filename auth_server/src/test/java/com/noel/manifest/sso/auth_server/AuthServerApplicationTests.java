package com.noel.manifest.sso.auth_server;

import com.noel.manifest.sso.auth_server.dao.UserDao;
import com.noel.manifest.sso.auth_server.model.RoleModel;
import com.noel.manifest.sso.auth_server.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AuthServerApplicationTests {

    @Autowired
UserDao userDao;

    @Test
    void showPass(){
        System.out.print(new BCryptPasswordEncoder().encode("123123"));
    }
    @Test
    void contextLoads() {
        UserModel u1 = new UserModel();
        u1.setUsername("javaboy");
        u1.setPassword("123");
        u1.setAccountNonExpired(true);
        u1.setAccountNonLocked(true);
        u1.setCredentialsNonExpired(true);
        u1.setEnabled(true);
        List<RoleModel> rs1 = new ArrayList<>();
        RoleModel r1 = new RoleModel();
        r1.setName("ROLE_admin");
        r1.setNameZh("管理员");
        rs1.add(r1);
        u1.setRoles(rs1);
        userDao.save(u1);
        UserModel u2 = new UserModel();
        u2.setUsername("江南一点雨");
        u2.setPassword("123");
        u2.setAccountNonExpired(true);
        u2.setAccountNonLocked(true);
        u2.setCredentialsNonExpired(true);
        u2.setEnabled(true);
        List<RoleModel> rs2 = new ArrayList<>();
        RoleModel r2 = new RoleModel();
        r2.setName("ROLE_user");
        r2.setNameZh("普通用户");
        rs2.add(r2);
        u2.setRoles(rs2);
        userDao.save(u2);
    }

}
