package com.qdu.bookstore.buyer.service;

import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;


public interface BuyerService {
    void addUser(Buyer buyer);

    Boolean checkUsername(String buyer_username);

    Buyer login(String username,String password);

    Buyer getUserByUsername(String buyer_username);

    void changeBuyerPassword(String password, Buyer forgetpassworduser);

    ResultVO changeBuyerInfo(Buyer sessionBuyer, HttpServletRequest request);
}
