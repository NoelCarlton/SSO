package com.noel.manifest.sso.auth_server.service;

import com.noel.manifest.sso.auth_server.dao.UserDao;
import com.noel.manifest.sso.auth_server.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/8
 * Version 1.0
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = userDao.findUserModelByUsername(s);
        if(null==user){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
