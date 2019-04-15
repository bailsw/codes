package com.qdu.bookstore.mappers;

import com.qdu.bookstore.order.pojo.Order;
import com.qdu.bookstore.order.pojo.OrderExample;
import java.util.List;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
}