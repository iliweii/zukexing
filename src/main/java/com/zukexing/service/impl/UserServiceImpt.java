package com.zukexing.service.impl;

import com.zukexing.dao.UserDao;
import com.zukexing.pojo.User;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpt implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }
}
