package com.qdu.bookstore.order.controller;/**
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.order.pojo.Order;
import com.qdu.bookstore.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/1.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("getallorders")
    public PageInfo<Order> getAllOrders(Integer pagesize, Integer pagenum, HttpSession session){
        pagesize=5;
        if (pagenum==null){
            pagenum=1;
        }
        PageHelper.startPage(pagenum,pagesize);
        Buyer loggedUser = (Buyer) session.getAttribute("loggeduser");
        List<Order> allOrders = orderService.getAllOrdersByUserid(loggedUser.getBuyer_Id());
        PageInfo<Order> pageInfo=new PageInfo<>(allOrders);
        return pageInfo;
    }
    @RequestMapping("getorderbyid")
    public Order getOrderById(Integer orderid,HttpSession session){
        Buyer loggedUser = (Buyer) session.getAttribute("loggeduser");
        Order order=orderService.getOrderById(orderid,loggedUser);
        if (order!=null){
            return order;
        }
        return null;
    }
}
