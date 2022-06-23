package com.zukexing.dao;

import com.zukexing.pojo.Rent;
import org.springframework.stereotype.Repository;

@Repository
public interface RentDao {
    Integer insertRent(Rent rent);
//    Integer updateRent(Rent rent);
}
