package com.qdu.bookstore.order.service.impl;


import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.mappers.BookMapper;
import com.qdu.bookstore.mappers.OrderMapper;
import com.qdu.bookstore.order.pojo.Order;
import com.qdu.bookstore.order.service.OrderService;
import com.qdu.bookstore.utils.LoginUtils;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public ResultVO changeOrderStatus(int order_id,int status) {
        int i=orderMapper.changeOrderStatus(order_id,status);
        if (i!=0){
            return ResultVOUtil.success(null);
        }
        return ResultVOUtil.error(null);
    }

    @Override
    public List<Order> getAllOrdersByUserid(Integer id, Integer status) {
        if (status==null){
            ArrayList<Order> ordersByUser = orderMapper.getOrdersByUser(id,-1);
            return ordersByUser;
        }
        else {
            ArrayList<Order> ordersByUser = orderMapper.getOrdersByUser(id,status);
            return ordersByUser;
        }
    }

    @Override
    public ResultVO deleteOrderById(int id) {
        try {
            orderMapper.deleteById(id);
            return ResultVOUtil.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.error(null);
        }
    }

    @Override
    public ResultVO addOrder(HttpServletRequest request, String address, int amount, int book_id) {
        Buyer buyer = LoginUtils.getSessionBuyer(request);
        Book bookById = bookMapper.getBookById(String.valueOf(book_id));
        Order order = new Order();
        order.setOrderAddress(address);
        order.setOrderCreatedate(new Date());
        order.setOrderUserid(buyer.getBuyer_Id());
        order.setOrderItem(book_id);
        order.setOrderItemAmount(amount);
        order.setOrderPrice((int)bookById.getBook_price()*amount);
        try {
            orderMapper.addOrder(order);
            return ResultVOUtil.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error("fail");
        }
    }

    @Override
    public Order getOrderById(Integer orderid, Buyer loggedUser) {
        Order order = orderMapper.getOrderById(orderid);
        if (order != null) {
            return order;
        }
        return null;
    }


}
