package com.springoauth.code.serviceImpl;

import com.springoauth.code.dao.UserDao;
import com.springoauth.code.entity.User;
import com.springoauth.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuhuachuan on 16/5/11.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
