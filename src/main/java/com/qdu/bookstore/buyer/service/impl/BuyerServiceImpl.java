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
import com.qdu.bookstore.utils.StaticVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerMapper buyerMapper;

    @Override
    public Buyer login(Buyer buyer) {
        String buyer_username = buyer.getBuyer_Username();
        String buyer_password = MD5Util.MD5Encode(buyer.getBuyer_Password(),"MD5");
        Buyer buyer1 = buyerMapper.selectBuyerByUsernameAndPassword(buyer_username, buyer_password);
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
    public void addUser(Buyer buyer) {
        buyer.setBuyer_Registertime(new Date());
    }


    @Override
    public int changeBuyerPassword(String password, Buyer forgetpassworduser) {
        return 0;
    }

    @Override
    public Buyer getUserByUsername(String buyer_username) {
        Buyer buyer = buyerMapper.selectBuyerByUsername(buyer_username);
        return buyer;
    }
}
