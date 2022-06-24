package com.zukexing.service.impl;

import com.zukexing.dao.UserDao;
import com.zukexing.pojo.User;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpt implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<LinkedHashMap> login(String phone) {
        List<LinkedHashMap> user = userDao.queryByPhone(phone);
        if (user.size() == 0) {
            // 新增user
            User new_user = new User();
            new_user.setUserAvater("default_avater.png");
            new_user.setUserNick("租客_" + getRandomString(7));
            new_user.setUserSex("");
            new_user.setUserPhone(phone);
            new_user.setIsReal(0);
            new_user.setExper(0);
            new_user.setCreateTime(new Date());
            new_user.setIsLandlord(0);
            new_user.setStatus(2);
            int res = userDao.insertUser(new_user);
            user = userDao.queryByPhone(phone);
        }
        return user;
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
