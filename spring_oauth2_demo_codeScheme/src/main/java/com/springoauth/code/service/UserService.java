package com.springoauth.code.service;

import com.springoauth.code.entity.User;

/**
 * Created by wuhuachuan on 16/5/11.
 */
public interface UserService {

    public User findByUsername(String username);
}
