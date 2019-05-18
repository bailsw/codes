package com.qdu.bookstore.order.service;
import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.order.pojo.Order;
import com.qdu.bookstore.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface OrderService {

    List<Order> getAllOrdersByUserid(Integer id, Integer status);

    Order getOrderById(Integer orderid, Buyer loggedUser);

    ResultVO addOrder(HttpServletRequest request, String address, int amount, int book_id);

    ResultVO deleteOrderById(int id);

    ResultVO changeOrderStatus(int order_id,int status);
}
