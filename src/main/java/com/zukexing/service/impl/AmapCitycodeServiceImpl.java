package com.zukexing.service.impl;

import com.zukexing.dao.AmapCitycodeDao;
import com.zukexing.pojo.AmapCitycode;
import com.zukexing.service.AmapCitycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmapCitycodeServiceImpl implements AmapCitycodeService {
    @Autowired
    private AmapCitycodeDao amapCitycodeDao;
    @Override
    public String queryAdcode(AmapCitycode amapCitycode) {
        return amapCitycodeDao.queryAdcode(amapCitycode);
    }
}
