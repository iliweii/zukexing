package com.zukexing.service;

import com.zukexing.pojo.User;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserService {
    Integer insertUser(User user);
    List<LinkedHashMap> login(String phone);
}
