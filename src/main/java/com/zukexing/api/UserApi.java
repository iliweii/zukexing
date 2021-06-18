package com.zukexing.api;

import com.google.gson.Gson;
import com.zukexing.pojo.User;
import com.zukexing.service.HouseService;
import com.zukexing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;

import static com.sun.xml.internal.ws.util.JAXWSUtils.getUUID;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Value("${file.path1}")
    private String avaterRootPath;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(@RequestParam("phone") String phone){
        List<LinkedHashMap> u = userService.login(phone);
        Gson gson = new Gson();
        String json = gson.toJson(u.get(0));
        return json;
    }

    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
    public String update(@RequestParam("user") String userjson){
        Gson gson = new Gson();
        User user = gson.fromJson(userjson, User.class);
        int res = userService.updateUser(user);
        if (res == 1)
            return "success";
        else
            return "failed";
    }

    @RequestMapping(value = "/updateavater")
    public String fileUpload(
            @RequestParam("avater") MultipartFile avater,
            @RequestParam("userid") int userid)
    {
        String filePath = "";
        String originalFilename = avater.getOriginalFilename();
        String appendFilename = System.currentTimeMillis() + originalFilename;
        filePath = new StringBuilder(avaterRootPath)
                .append(appendFilename)
                .toString();
        try {
            // 保存文件
            avater.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return "failed";
        }
        User user = new User();
        user.setUserId(userid);
        user.setUserAvater(appendFilename);
        int res = userService.updateUser(user);
        if (res == 1)
            return appendFilename;
        else
            return "failed";
    }

}
