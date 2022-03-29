package com.service;
import com.bean.Order;

import java.util.List;

public interface OrderService {
    boolean insertOrder(String parkingSpaceId,String contractSignatory,String contractInitiator,String AdminName);

    List<Order> selectUserOrder(String userIdentity);

    public Order selectOrderById(String orderId);

}
