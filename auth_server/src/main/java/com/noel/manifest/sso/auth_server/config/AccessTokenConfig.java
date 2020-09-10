package com.noel.manifest.sso.auth_server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/10
 * Version 1.0
 **/
@Configuration
public class AccessTokenConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
}
