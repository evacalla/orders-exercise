package com.order.v1.services;

import com.order.cache.BumexMemcached;
import com.order.dao.OrderDao;
import com.order.domain.Order;
import com.order.exception.OrderBadRequestException;
import com.order.exception.OrderNotFoundException;
import com.order.utils.Validate;
import com.order.v1.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by evacalla on 8/12/2019
 **/

@Service
public class OrderService {

    private BumexMemcached bumexMemcached = BumexMemcached.getInstance();
    private OrderDao dao;


    public void save(OrderVO vo){
        Order order = this.convert2(vo);
        this.dao.insertOrUpdate(order);
        this.bumexMemcached.set("id", vo);
    }

    public OrderVO get(String id){
        OrderVO orderVO = this.findOrderVO(id);
        if(Objects.isNull(orderVO)) {
            Order order = this.findOrder(id);
            return this.convert2VO(order);
        }
        return orderVO;
    }

    public void put(OrderVO vo, String id){
        Optional.ofNullable(this.findOrderVO(id))
                .orElseThrow(() -> new OrderNotFoundException("id", id));
        Order order = this.convert2(vo);
        this.dao.insertOrUpdate(order);
        this.bumexMemcached.set(id, vo);
    }

    public void delete(String id){
        Order order = this.findOrder(id);
        this.dao.remove(order.getId());
        this.bumexMemcached.delete(order.getId().toString());
    }

    private Order findOrder(String id){
        if(!Validate.isNumeric(id)) { throw new OrderBadRequestException("id", id); };
        return Optional.ofNullable(this.dao.select(Long.parseLong(id)))
                .orElseThrow(() -> new OrderNotFoundException("id",  id));
    }

    private OrderVO findOrderVO(String id){
        if(!Validate.isNumeric(id)) { throw new OrderBadRequestException("id", id); };
        return (OrderVO) this.bumexMemcached.get(id);
    }

    private OrderVO convert2VO(Order order){
        OrderVO vo = new OrderVO();
        vo.setAmount(order.getAmount());
        vo.setDiscount(order.getDiscount());
        vo.setName(order.getName());
        vo.setId(order.getId());
        return vo;
    }

    private Order convert2(OrderVO vo){
        Order order = new Order();
        order.setName(vo.getName());
        order.setAmount(vo.getAmount());
        return order;
    }

}
