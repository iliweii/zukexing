package com.zukexing.dao;

import com.zukexing.pojo.House;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface HouseDao {

    Integer insertHouse(House house);
    House queryById(int id);
    Integer queryIdByName(String name);
    List<House> queryAll();
    List<LinkedHashMap> queryByType(int page, int count, String rentType);

}
