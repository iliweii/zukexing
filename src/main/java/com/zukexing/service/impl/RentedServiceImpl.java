package com.zukexing.service.impl;

import com.zukexing.dao.RentedDao;
import com.zukexing.pojo.Rented;
import com.zukexing.service.RentedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RentedServiceImpl implements RentedService {

    @Autowired
    private RentedDao rentedDao;
    @Override
    public Integer insert(Rented rented) {
        return rentedDao.insert(rented);
    }

    @Override
    public List<LinkedHashMap> list(int userId) {
        return rentedDao.list(userId);
    }
}
