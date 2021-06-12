package com.zukexing.dao;

import com.zukexing.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    Integer insertUser(User user);
}
