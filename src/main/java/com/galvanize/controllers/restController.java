package com.galvanize.controllers;

import com.galvanize.entities.Order;
import com.galvanize.services.FastFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class restController {
    FastFoodService fastFoodService;

    @Autowired
    public restController(FastFoodService fastFoodService) {
        this.fastFoodService = fastFoodService;
    }


    @PostMapping("")
    public Order createOrder(@RequestBody Order order) {
        return fastFoodService.createOrder(order);
    }

}
