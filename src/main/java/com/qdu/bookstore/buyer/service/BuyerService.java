package com.qdu.bookstore.buyer.service;

import com.qdu.bookstore.buyer.pojo.Buyer;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
public interface BuyerService {
    void addUser(Buyer buyer);

    Boolean checkUsername(String buyer_username);

    Buyer login(Buyer buyer);

    Buyer getUserByUsername(String buyer_username);

    int changeBuyerPassword(String password, Buyer forgetpassworduser);
}
