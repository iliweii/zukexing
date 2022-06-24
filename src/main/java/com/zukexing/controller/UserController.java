package com.zukexing.controller;

import com.google.gson.Gson;
import com.zukexing.pojo.Attr;
import com.zukexing.pojo.House;
import com.zukexing.pojo.Rent;
import com.zukexing.pojo.User;
import com.zukexing.service.HouseService;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Value("${file.path1}")
    private String avaterRootPath;
    @Autowired
    private UserService userService;
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ResponseBody
    @PostMapping("/insertUser")
    public String insertHouse(
            @RequestParam("user") String userJson, @RequestParam("avater") MultipartFile avater){
        String filePath = "";
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        String originalFilename = avater.getOriginalFilename();
        String avaterFilename = System.currentTimeMillis() + originalFilename;
        // 存储路径
        filePath = new StringBuilder(avaterRootPath)
            .append(System.currentTimeMillis())
            .append(originalFilename)
            .toString();
        try {
            // 保存文件
            avater.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setUserAvater(avaterFilename);
        if (user.getIsReal() == null) {
            user.setIsReal(0);
        }
        if (user.getExper() == null) {
            user.setExper(0);
        }
        if (user.getIsLandlord() == null) {
            user.setIsLandlord(0);
        }
        if (user.getStatus() == null) {
            user.setStatus(2); // 默认为审核通过的
        }
        String nowTime = formatter.format(new Date());
        user.setCreateTime(new Date());

        int res = userService.insertUser(user);
        if (res == 1)
            return "success";
        else
            return "error";
    }

}
