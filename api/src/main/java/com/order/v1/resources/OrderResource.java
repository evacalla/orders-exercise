package com.order.v1.resources;

import com.order.v1.services.OrderService;
import com.order.v1.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by evacalla on 8/12/2019
 **/

@RestController(OrderResource.NAME)
@RequestMapping(value = OrderResource.PATH)
public class OrderResource {

    public static final String PATH = "/order";
    public static final String NAME = "ORDER_V1";
    private OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity post(@Valid @RequestBody OrderVO vo){
        orderService.save(vo);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity put(@PathVariable("id") String id, @Valid @RequestBody OrderVO vo){
        orderService.put(vo, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") String id){
        return ResponseEntity.ok(orderService.get(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id){
        orderService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
