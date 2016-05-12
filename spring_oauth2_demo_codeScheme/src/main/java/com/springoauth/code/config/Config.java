package com.springoauth.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by wuhuachuan on 16/5/11.
 */

//@Configuration
public class Config {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTokenStore createJdbcTokenStore(){
        return new JdbcTokenStore(dataSource);
    }

}
