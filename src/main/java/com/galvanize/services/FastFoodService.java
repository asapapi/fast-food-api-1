package com.galvanize.services;


import com.galvanize.entities.Order;
import com.galvanize.repositories.FastFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FastFoodService {

    @Autowired
    FastFoodRepository fastFoodRepository;

    public FastFoodService() {
    }

    public FastFoodService(FastFoodRepository fastFoodRepository) {
        this.fastFoodRepository = fastFoodRepository;
    }

    public Order createOrder(Order order) {
        LocalDate localDate = LocalDate.now();
        order.setLastUpdated(localDate);
        order.setCreatedAt(localDate);
        return fastFoodRepository.save(order);
    }
}
