package com.noel.manifest.sso.auth_server.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/8
 * Version 1.0
 **/
@Entity(name = "t_role")
@Data
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameZh;
}
