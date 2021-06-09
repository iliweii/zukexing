package com.zukexing.api;

import com.zukexing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/house")
public class HouseApi {

    @Autowired
    private HouseService houseService;
    private int count = 7; // 默认每次更新7条数据

    @RequestMapping(value = "/reco", produces = "text/html;charset=UTF-8")
    public String reco(@RequestParam("page") int page){
        return houseService.queryByType(page, count, "reco");
    }
    @RequestMapping(value = "/mini", produces = "text/html;charset=UTF-8")
    public String mini(@RequestParam("page") int page){
        return houseService.queryByType(page, count, "mini");
    }
    @RequestMapping(value = "/short", produces = "text/html;charset=UTF-8")
    public String shortE(@RequestParam("page") int page){
        return houseService.queryByType(page, count, "short");
    }
    @RequestMapping(value = "/long", produces = "text/html;charset=UTF-8")
    public String longE(@RequestParam("page") int page){
        return houseService.queryByType(page, count, "long");
    }
}
