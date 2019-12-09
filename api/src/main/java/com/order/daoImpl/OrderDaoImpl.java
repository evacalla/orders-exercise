package com.order.daoImpl;

import com.order.dao.OrderDao;
import com.order.domain.Order;

/**
 * Created by evacalla on 8/12/2019
 **/
public class OrderDaoImpl implements OrderDao {


    @Override
    public void insertOrUpdate(Order order) {
        //TODO
    }

    @Override
    public boolean remove(Long orderId) {
        return false;
    }

    @Override
    public Order select(Long oderId) {
        return null;
    }
}
