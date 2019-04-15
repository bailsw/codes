package com.qdu.bookstore.order.service.impl;/**
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
import com.qdu.bookstore.mappers.OrderMapper;
import com.qdu.bookstore.order.pojo.Order;
import com.qdu.bookstore.order.pojo.OrderExample;
import com.qdu.bookstore.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(Integer orderid, Buyer loggedUser) {
        OrderExample example=new OrderExample();
        example.createCriteria().andOrderIdEqualTo(orderid).andOrderUseridEqualTo(loggedUser.getBuyer_Id());
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders.size()!=0){
            return orders.get(0);
        }
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUserid(int id) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderUseridEqualTo(id);
        return orderMapper.selectByExample(orderExample);
    }
}
