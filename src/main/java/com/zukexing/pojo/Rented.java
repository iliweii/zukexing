package com.zukexing.pojo;


public class Rented {

  private Integer rentedId;
  private Integer userId;
  private Integer houseId;
  private String startTime;
  private String endTime;
  private String createTime;
  private Double pay;
  private Double payH;
  private Double payD;
  private Integer status;


  public Integer getRentedId() {
    return rentedId;
  }

  public void setRentedId(Integer rentedId) {
    this.rentedId = rentedId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getHouseId() {
    return houseId;
  }

  public void setHouseId(Integer houseId) {
    this.houseId = houseId;
  }


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public Double getPay() {
    return pay;
  }

  public void setPay(Double pay) {
    this.pay = pay;
  }


  public Double getPayH() {
    return payH;
  }

  public void setPayH(Double payH) {
    this.payH = payH;
  }


  public Double getPayD() {
    return payD;
  }

  public void setPayD(Double payD) {
    this.payD = payD;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
