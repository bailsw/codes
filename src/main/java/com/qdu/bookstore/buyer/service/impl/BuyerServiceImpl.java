package com.qdu.bookstore.buyer.service.impl;/**
*                                                                      : ,       
*                                  +7?==?O$~                           :7?,, :~=,
*                                +Z~       +Z~,                        :I+IIO+++ 
*                              ,7=,          7:,                       :?:~Z8=   
*                              :I,            7,                       +?~IZ,    
*                             ,I:   ?     ?    ?                  ,~+Z+ :~+      
*                              $,              I,             ,:~77~, ,I7=       
*                             :Z                ?:   :~~+?Z$7I+: ,,,~7+          
*                              $,                7Z7I+::         :?$+,            
*                             ,?+                           ,+7I=                 
*                              ,7:                   ,:,=N?~,                    
*                             :7$,                   IZI$?                       
*                           ?$+: ,                    ++                         
*                         ~$ ,                        ,:I~                       
*    ,                   7=                              :I$~                    
*   ,O+               =I7$7, , ,     ,                      ,77:,                
*   ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~               
*~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,            
*+D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+            
*     =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,          
*                                           :O?,      :, ?:, ,,,,,,,,,$:         
*                                             ,+I:,    ,?+,, ,,,,,,,,,,7=        
*                                                :I77~ :Z, ,,,,,,,,,,,,,,?=       
*                                                  ,,I= I,,,,,,,,,,,,,,,,,?+      
*                                                     :~,                 :=     
*                     哪错了？             错哪了？              我是谁？
*/

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

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
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
