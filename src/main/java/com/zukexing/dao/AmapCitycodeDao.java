package com.zukexing.dao;

import com.zukexing.pojo.AmapCitycode;
import org.springframework.stereotype.Repository;

@Repository
public interface AmapCitycodeDao {
    String queryAdcode(AmapCitycode amapCitycode);
}
