package com.dao;
import com.bean.Order;
import com.bean.OrderStatistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    boolean insertOrder(Order order);

    List<Order> selectOrder(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize, @Param("search") String search,@Param("did") String did);
    boolean updateOrder(Order order);

    boolean updateOrderState(@Param("state") int state,@Param("orderId") String orderId);

    Order selectOrderById(@Param("orderId")String orderId);

    List<Order> selectAllOrderByDid(@Param("did") String did);

    List<OrderStatistic> selectStatisticOrder(@Param("did") String did,@Param("state") int state);

    List<Order> selectUserOrder(@Param("userIdentity")String userIdentity);
}
