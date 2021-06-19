package com.zukexing.api;

import com.google.gson.Gson;
import com.zukexing.pojo.Rented;
import com.zukexing.service.RentedService;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/rented")
public class RentedApi {
    @Autowired
    private RentedService rentedService;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/insert", produces = "text/html;charset=UTF-8")
    public String insert(@RequestParam("rented") String rentedjson) {
        Gson gson = new Gson();
        Rented rented = gson.fromJson(rentedjson, Rented.class);
        String nowTime = formatter.format(new Date());
        rented.setCreateTime(nowTime);
        rented.setStatus(3);
        int res = rentedService.insert(rented);
        if (res > 0)
            return "success";
        else
            return "failed";
    }

    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
    public String list(@RequestParam("userId") int userId) {
        List<LinkedHashMap> r = rentedService.list(userId);
        Gson gson = new Gson();
        String json = gson.toJson(r);
        return json;
    }

}
