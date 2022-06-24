package com.zukexing.controller;

import com.google.gson.Gson;
import com.zukexing.pojo.Attr;
import com.zukexing.pojo.House;
import com.zukexing.pojo.Rent;
import com.zukexing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/house")
public class HouseController {

    @Value("${file.path2}")
    private String fileRootPath;
    @Autowired
    private HouseService houseService;
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ResponseBody
    @PostMapping("/file")
    public String fileUpload(@RequestParam("files") MultipartFile[] files){
        String filePath = "";
        // 多文件上传
        for (MultipartFile file : files){
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            // 存储路径
            filePath = new StringBuilder(fileRootPath)
                    .append(System.currentTimeMillis())
                    .append(originalFilename)
                    .toString();
            try {
                // 保存文件
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

    @ResponseBody
    @PostMapping("/insertHouse")
    public String insertHouse(
            @RequestParam("house") String houseJson,
            @RequestParam("rent") String rentJson,
            @RequestParam("attr") String attrJson,
            @RequestParam("images") MultipartFile[] files){
        String filePath = "";
        Gson gson = new Gson();
        List<String> filenames = new ArrayList<String>();
        for (MultipartFile file : files){
            String originalFilename = file.getOriginalFilename();
            String appendFilename = System.currentTimeMillis() + originalFilename;
            filePath = new StringBuilder(fileRootPath)
                    .append(appendFilename)
                    .toString();
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            filenames.add(appendFilename);
        }
        String house_img = gson.toJson(filenames);
        String nowTime = formatter.format(new Date());

        House house = gson.fromJson(houseJson, House.class);
        Rent rent = gson.fromJson(rentJson, Rent.class);
        Attr attr = gson.fromJson(attrJson, Attr.class);
        house.setHouseImg(house_img);
        house.setCreateTime(new Date());
        house.setUpdateTime(new Date());
        house.setStatus(4); // TODO 初级阶段默认为已审核

        int res = houseService.insertHouse(house, rent, attr);
        if (res == 1)
            return "success";
        else
            return "error";
    }

    @ResponseBody
    @PostMapping("/queryHouseByType")
    public String queryHouseByType(
            @RequestParam("type") String type,
            @RequestParam("page") int page){
        int count = 7; // TODO 默认每次更新7条数据

        return houseService.queryByType(page, count, type);
    }

}
