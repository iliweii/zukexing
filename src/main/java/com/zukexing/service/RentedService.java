package com.zukexing.service;

import com.zukexing.pojo.Rented;

import java.util.LinkedHashMap;
import java.util.List;

public interface RentedService {
    Integer insert(Rented rented);
    List<LinkedHashMap> list(int userId);
}
