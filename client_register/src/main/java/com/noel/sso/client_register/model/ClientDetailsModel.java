package com.noel.sso.client_register.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/11
 * Version 1.0
 **/
@Data
@Entity(name = "oauth_client_details")
public class ClientDetailsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "client_id")
    private String client_id;

    @Column(length = 10, name = "resource_ids")
    private String resource_ids;

    @Column(length = 100, name = "client_secret")
    private String client_secret;

    @Column(length = 10, name = "scope")
    private String scope;

    @Column(length = 100, name = "authorized_grant_types")
    private String authorized_grant_types;

    @Column(length = 150, name = "web_server_redirect_uri")
    private String web_server_redirect_uri;

    @Column(name = "autoapprove")
    private Boolean autoapprove;


}
