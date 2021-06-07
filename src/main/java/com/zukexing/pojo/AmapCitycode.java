package com.zukexing.pojo;

public class AmapCitycode {
    private String city_name;
    private String adcode;
    private String citycode;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public String toString() {
        return "AmapCitycode{" +
                "city_name='" + city_name + '\'' +
                ", adcode='" + adcode + '\'' +
                ", citycode='" + citycode + '\'' +
                '}';
    }
}
