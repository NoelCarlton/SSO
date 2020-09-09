package com.noel.manifest.sso.auth_server.dao;

import com.noel.manifest.sso.auth_server.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/7
 * Version 1.0
 **/
@Repository
public interface UserDao extends JpaRepository<UserModel, Long> {
    UserModel findUserModelByUsername(String username);
}
