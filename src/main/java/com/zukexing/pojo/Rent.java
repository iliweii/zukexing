package com.zukexing.pojo;


public class Rent {

  private Integer rentId;
  private Integer homeId;
  private String rentType;
  private Double miniPrice;
  private Double miniDept;
  private Double shortPrice;
  private Double shortDept;
  private Double longPrice;
  private Double longDept;


  public Integer getRentId() {
    return rentId;
  }

  public void setRentId(Integer rentId) {
    this.rentId = rentId;
  }


  public Integer getHomeId() {
    return homeId;
  }

  public void setHomeId(Integer homeId) {
    this.homeId = homeId;
  }


  public String getRentType() {
    return rentType;
  }

  public void setRentType(String rentType) {
    this.rentType = rentType;
  }


  public Double getMiniPrice() {
    return miniPrice;
  }

  public void setMiniPrice(Double miniPrice) {
    this.miniPrice = miniPrice;
  }


  public Double getMiniDept() {
    return miniDept;
  }

  public void setMiniDept(Double miniDept) {
    this.miniDept = miniDept;
  }


  public Double getShortPrice() {
    return shortPrice;
  }

  public void setShortPrice(Double shortPrice) {
    this.shortPrice = shortPrice;
  }


  public Double getShortDept() {
    return shortDept;
  }

  public void setShortDept(Double shortDept) {
    this.shortDept = shortDept;
  }


  public Double getLongPrice() {
    return longPrice;
  }

  public void setLongPrice(Double longPrice) {
    this.longPrice = longPrice;
  }


  public Double getLongDept() {
    return longDept;
  }

  public void setLongDept(Double longDept) {
    this.longDept = longDept;
  }

}
