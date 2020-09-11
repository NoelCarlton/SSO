package com.noel.sso.client_register.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/11
 * Version 1.0
 **/
@Data
//@Entity
public class ClientDetailsModel implements Serializable {
    private String client_id;
    private String resource_ids;
    private String client_secret;
    private String scope;
    private String authorized_grant_types;
    private String web_server_redirect_uri;
    private Boolean autoapprove;
}
