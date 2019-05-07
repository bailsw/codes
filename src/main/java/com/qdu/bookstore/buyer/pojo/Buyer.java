package com.qdu.bookstore.buyer.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
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
  private int buyer_type;


}
