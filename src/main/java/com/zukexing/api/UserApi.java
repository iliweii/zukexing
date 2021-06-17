package com.zukexing.api;

import com.google.gson.Gson;
import com.zukexing.pojo.User;
import com.zukexing.service.HouseService;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(@RequestParam("phone") String phone){
        List<LinkedHashMap> u = userService.login(phone);
        Gson gson = new Gson();
        String json = gson.toJson(u.get(0));
        return json;
    }
}
