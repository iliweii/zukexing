package com.zukexing.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Admin {

  private Integer adminId;
  private String adminPhone;
  private String adminPwd;
  private String adminNick;
  private String adminType;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  private Integer status;


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }


  public String getAdminPhone() {
    return adminPhone;
  }

  public void setAdminPhone(String adminPhone) {
    this.adminPhone = adminPhone;
  }


  public String getAdminPwd() {
    return adminPwd;
  }

  public void setAdminPwd(String adminPwd) {
    this.adminPwd = adminPwd;
  }


  public String getAdminNick() {
    return adminNick;
  }

  public void setAdminNick(String adminNick) {
    this.adminNick = adminNick;
  }


  public String getAdminType() {
    return adminType;
  }

  public void setAdminType(String adminType) {
    this.adminType = adminType;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
