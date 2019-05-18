package com.qdu.bookstore.order.controller;
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
