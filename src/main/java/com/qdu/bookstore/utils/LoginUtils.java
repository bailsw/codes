package com.qdu.bookstore.utils;

import com.qdu.bookstore.buyer.pojo.Buyer;

import javax.servlet.http.HttpServletRequest;

public class LoginUtils {
    public static Buyer getSessionBuyer(HttpServletRequest request){
        return (Buyer) request.getSession().getAttribute("loggeduser");
    }
}
