package com.zukexing.api;

import com.zukexing.pojo.AmapCitycode;
import com.zukexing.service.AmapCitycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amapcitycode")
public class AmapCitycodeApi {
    @Autowired
    private AmapCitycodeService amapCitycodeService;

    @RequestMapping(value = "/queryadcode", produces = "text/html;charset=UTF-8")
    public String queryadcode(@RequestParam("city_name") String city_name) {
        AmapCitycode amapCitycode = new AmapCitycode();
        amapCitycode.setCity_name(city_name);
        return amapCitycodeService.queryAdcode(amapCitycode);
    }
}
