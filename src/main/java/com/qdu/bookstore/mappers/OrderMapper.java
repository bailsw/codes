package com.qdu.bookstore.mappers;

import com.qdu.bookstore.order.pojo.Order;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "orderMapper")
public interface OrderMapper {
   void addOrder(Order order);

    Order getOrderById(@Param(value = "order_id") Integer orderid);

    ArrayList<Order> getOrdersByUser(@Param(value = "buyer_id") Integer id, @Param(value = "status") Integer status);

    void deleteById(@Param(value = "id") int id);
}