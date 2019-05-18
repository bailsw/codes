package com.qdu.bookstore.buyer.service.impl;
import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.buyer.service.BuyerService;
import com.qdu.bookstore.mappers.BuyerMapper;
import com.qdu.bookstore.utils.MD5Util;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.utils.StaticVariables;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerMapper buyerMapper;

    @Override
    public Buyer login(String username,String password) {

        String buyer_password = MD5Util.MD5Encode(password,"utf-8");
        //System.out.println(buyer_password);
        Buyer buyer1 = buyerMapper.selectBuyerByUsernameAndPassword(username, buyer_password);
        return buyer1;
    }

    @Override
    public Boolean checkUsername(String buyer_username) {
        Buyer buyer=buyerMapper.selectBuyerByUsername(buyer_username);
        if (buyer==null){
            return StaticVariables.USER_NOT_EXIST;
        }
        return StaticVariables.USER_EXISTS;
    }

    @Override
    public ResultVO changeBuyerInfo(Buyer sessionBuyer, HttpServletRequest request) {
        try {
            buyerMapper.updateBuyer(sessionBuyer);
            request.getSession().setAttribute("loggeduser",sessionBuyer);
        }catch (Exception e){
            return ResultVOUtil.error("");
        }
        return ResultVOUtil.success("");
    }

    @Override
    public void addUser(Buyer buyer) {
        buyer.setBuyer_Registertime(new Date());
        buyerMapper.addBuyer(buyer);
    }


    @Override
    public void changeBuyerPassword(String password, Buyer forgetpassworduser) {
        forgetpassworduser.setBuyer_Password(MD5Util.MD5Encode(password, "utf-8"));
        buyerMapper.updateBuyer(forgetpassworduser);
    }

    @Override
    public Buyer getUserByUsername(String buyer_username) {
        Buyer buyer = buyerMapper.selectBuyerByUsername(buyer_username);
        return buyer;
    }
}
