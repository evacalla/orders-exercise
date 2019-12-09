package com.order.dao;

import com.order.domain.Order;

public interface OrderDao {

    void insertOrUpdate(Order order);
    boolean remove(Long orderId);
    Order select(Long oderId);

}
