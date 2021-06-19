package com.zukexing.dao;

import com.zukexing.pojo.Rented;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface RentedDao {
    Integer insert(Rented rented);
    List<LinkedHashMap> list(int userId);
}
