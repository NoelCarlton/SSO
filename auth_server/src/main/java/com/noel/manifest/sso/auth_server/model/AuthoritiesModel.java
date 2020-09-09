package com.noel.manifest.sso.auth_server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/7
 * Version 1.0
 **/
//@Entity
//@Table(name = "authorities")
@Data
public class AuthoritiesModel implements Serializable {

    @Id
    @Column(length = 50, nullable = false)
    private String username;

    @Id
    @Column(nullable = false, length = 50)
    private String authority;


    private String fk_authorities_users;
}