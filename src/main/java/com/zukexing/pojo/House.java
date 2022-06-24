package com.zukexing.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class House {

  private Integer houseId;
  private String houseTitle;
  private String houseType;
  private String houseArea;
  private String houseFloor;
  private String houseDir;
  private String houseIntro;
  private String houseLocal;
  private String houseRequire;
  private String houseImg;
  private Integer userId;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date updateTime;
  private Integer status;


  public Integer getHouseId() {
    return houseId;
  }

  public void setHouseId(Integer houseId) {
    this.houseId = houseId;
  }


  public String getHouseTitle() {
    return houseTitle;
  }

  public void setHouseTitle(String houseTitle) {
    this.houseTitle = houseTitle;
  }


  public String getHouseType() {
    return houseType;
  }

  public void setHouseType(String houseType) {
    this.houseType = houseType;
  }


  public String getHouseArea() {
    return houseArea;
  }

  public void setHouseArea(String houseArea) {
    this.houseArea = houseArea;
  }


  public String getHouseFloor() {
    return houseFloor;
  }

  public void setHouseFloor(String houseFloor) {
    this.houseFloor = houseFloor;
  }


  public String getHouseDir() {
    return houseDir;
  }

  public void setHouseDir(String houseDir) {
    this.houseDir = houseDir;
  }


  public String getHouseIntro() {
    return houseIntro;
  }

  public void setHouseIntro(String houseIntro) {
    this.houseIntro = houseIntro;
  }


  public String getHouseLocal() {
    return houseLocal;
  }

  public void setHouseLocal(String houseLocal) {
    this.houseLocal = houseLocal;
  }



  public String getHouseRequire() {
    return houseRequire;
  }

  public void setHouseRequire(String houseRequire) {
    this.houseRequire = houseRequire;
  }


  public String getHouseImg() {
    return houseImg;
  }

  public void setHouseImg(String houseImg) {
    this.houseImg = houseImg;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
