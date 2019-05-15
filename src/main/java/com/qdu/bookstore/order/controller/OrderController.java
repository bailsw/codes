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
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("getordersbyuseridandstatus")
    public PageInfo<Order> getAllOrders(Integer pagesize, Integer pagenum,Integer status, HttpServletRequest request){
        pagesize=5;
        if (pagenum==null){
            pagenum=1;
        }
        PageHelper.startPage(pagenum,pagesize);
        Buyer loggedUser = (Buyer) request.getSession().getAttribute("loggeduser");

        List<Order> allOrders = orderService.getAllOrdersByUserid(loggedUser.getBuyer_Id(),status);
        PageInfo<Order> pageInfo=new PageInfo<>(allOrders);
        return pageInfo;
    }
    @RequestMapping("getorderbyorderid")
    public ResultVO getOrderById(Integer orderid, HttpServletRequest request){
        Buyer loggedUser = (Buyer) request.getSession().getAttribute("loggeduser");
        Order order=orderService.getOrderById(orderid,loggedUser);
        if (order!=null){
            return ResultVOUtil.success(order);
        }
        return ResultVOUtil.error("fail");
    }
    @RequestMapping("addorder")
    public ResultVO addOrder(HttpServletRequest request,
                             @RequestParam(value = "book_amount")int amount,
                             @RequestParam(value = "bookId")int book_id,
                             @RequestParam(value = "orderAddress")String address){
        return  orderService.addOrder(request,address,amount,book_id);
    }
    @RequestMapping("getallordersbystatus")
    public PageInfo<Order> getAllOrdersByStatus(Integer status,int pagenum){
        PageHelper.startPage(pagenum,10);
        List<Order> allOrdersByUserid = orderService.getAllOrdersByUserid(null, status);
        return new PageInfo<>(allOrdersByUserid);
    }
    @RequestMapping("deleteorderbyid")
    public ResultVO deleteOrderById(int id){
        return orderService.deleteOrderById(id);
    }
    @RequestMapping("changeorderstatus")
    public ResultVO changeOrderStatus(int order_id,int status){
        return orderService.changeOrderStatus(order_id,status);
    }
}
