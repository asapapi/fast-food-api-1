package com.galvanize.controllers;

import com.galvanize.entities.Order;
import com.galvanize.services.FastFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Order> getAll(){
        return fastFoodService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return fastFoodService.getById(id);
    }

    @PutMapping("/{id}")
    public Order updateById(@PathVariable Long id, @RequestBody Order order){
        return fastFoodService.updateById(id,order);
    }

}
