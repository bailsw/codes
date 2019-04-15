package com.qdu.bookstore.buyer.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Buyer implements Serializable{

  private int buyer_Id;
  private String buyer_Username;
  @JsonIgnore
  private String buyer_Password;
  @JsonIgnore
  private String buyer_Salt;
  private String buyer_Phone;
  private String buyer_Email;
  @JsonIgnore
  private Date buyer_Lastlogintime;
  @JsonIgnore
  private Date buyer_Registertime;
  @JsonIgnore
  private String buyer_Passwordquestion;
  @JsonIgnore
  private String buyer_Passwordanswer;


  public int getBuyer_Id() {
    return buyer_Id;
  }

  public void setBuyer_Id(int buyer_Id) {
    this.buyer_Id = buyer_Id;
  }


  public String getBuyer_Username() {
    return buyer_Username;
  }

  public void setBuyer_Username(String buyer_Username) {
    this.buyer_Username = buyer_Username;
  }


  public String getBuyer_Password() {
    return buyer_Password;
  }

  public void setBuyer_Password(String buyer_Password) {
    this.buyer_Password = buyer_Password;
  }


  public String getBuyer_Salt() {
    return buyer_Salt;
  }

  public void setBuyer_Salt(String buyer_Salt) {
    this.buyer_Salt = buyer_Salt;
  }


  public String getBuyer_Phone() {
    return buyer_Phone;
  }

  public void setBuyer_Phone(String buyer_Phone) {
    this.buyer_Phone = buyer_Phone;
  }


  public String getBuyer_Email() {
    return buyer_Email;
  }

  public void setBuyer_Email(String buyer_Email) {
    this.buyer_Email = buyer_Email;
  }


  public Date getBuyer_Lastlogintime() {
    return buyer_Lastlogintime;
  }

  public void setBuyer_Lastlogintime(Date buyer_Lastlogintime) {
    this.buyer_Lastlogintime = buyer_Lastlogintime;
  }

  public Date getBuyer_Registertime() {
    return buyer_Registertime;
  }

  public void setBuyer_Registertime(Date buyer_Registertime) {
    this.buyer_Registertime = buyer_Registertime;
  }

  public String getBuyer_Passwordquestion() {
    return buyer_Passwordquestion;
  }

  public void setBuyer_Passwordquestion(String buyer_Passwordquestion) {
    this.buyer_Passwordquestion = buyer_Passwordquestion;
  }


  public String getBuyer_Passwordanswer() {
    return buyer_Passwordanswer;
  }

  public void setBuyer_Passwordanswer(String buyer_Passwordanswer) {
    this.buyer_Passwordanswer = buyer_Passwordanswer;
  }

}
