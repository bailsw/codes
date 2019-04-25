package com.qdu.bookstore.order.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private Integer orderId;

    private int orderUserid;

    private int orderItem;

    private int orderItemAmount;

    private Integer orderPrice;

    private Integer orderStatus;

    private Date orderCreatedate;

    private Date orderConfirmdate;

    private String orderRemark;

    private String orderAddress;




}