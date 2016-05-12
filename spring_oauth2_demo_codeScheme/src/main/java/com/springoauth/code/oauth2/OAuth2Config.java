package com.springoauth.code.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by wuhuachuan on 16/5/12.
 */

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class OAuth2Config {

}
