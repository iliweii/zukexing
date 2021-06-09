package com.zukexing.service;

import com.zukexing.pojo.Attr;
import com.zukexing.pojo.House;
import com.zukexing.pojo.Rent;

import java.util.List;

public interface HouseService {
    Integer insertHouse(House house, Rent rent, Attr attr);
    List<House> queryAll();
    String queryByType(int page, int count, String rentType);
}
