package com.zukexing.service.impl;

import com.zukexing.dao.RentDao;
import com.zukexing.pojo.Rent;
import com.zukexing.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Override
    public Integer insertRent(Rent rent) {
        return rentDao.insertRent(rent);
    }
}
