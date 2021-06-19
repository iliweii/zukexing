package com.zukexing.service.impl;

import com.google.gson.Gson;
import com.zukexing.dao.AttrDao;
import com.zukexing.dao.HouseDao;
import com.zukexing.dao.RentDao;
import com.zukexing.pojo.Attr;
import com.zukexing.pojo.House;
import com.zukexing.pojo.Rent;
import com.zukexing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Autowired
    private RentDao rentDao;
    @Autowired
    private AttrDao attrDao;

    @Override
    public Integer insertHouse(House house, Rent rent, Attr attr) {
        int houseRes = houseDao.insertHouse(house);
        if (houseRes == 0)
            return 0;
        int house_id = houseDao.queryIdByName(house.getHouseTitle());
        rent.setHomeId(house_id);
        int rentRes = rentDao.insertRent(rent);
        attr.setHouseId(house_id);
        int attrRes = attrDao.insertAttr(attr);
        if (rentRes == 0 || attrRes == 0)
            return 0;
        return 1;
    }

    @Override
    public List<House> queryAll() {
        return null;
    }

    @Override
    public String queryByType(int page, int count, String rentType) {
        Gson gson = new Gson();
        if (rentType.equals("reco")) {
            rentType = "";
        }
        page = (page - 1) * count;
        rentType = "%" + rentType + "%";
        List<LinkedHashMap> datas = houseDao.queryByType(page, count, rentType);
        String json = gson.toJson(datas);
        return json;
    }

    @Override
    public List<LinkedHashMap> queryMy(int userId) {
        return houseDao.queryMy(userId);
    }
}
