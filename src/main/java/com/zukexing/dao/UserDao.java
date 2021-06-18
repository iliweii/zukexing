package com.zukexing.dao;

import com.zukexing.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface UserDao {
    Integer insertUser(User user);
    List<LinkedHashMap> queryByPhone(String phone);
    Integer updateUser(User user);
}
