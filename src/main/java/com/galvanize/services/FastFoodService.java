package com.galvanize.services;


import com.galvanize.entities.Order;
import com.galvanize.repositories.FastFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<Order> getAll() {
    return fastFoodRepository.findAll();
    }

    public Order getById(Long id) {
        return fastFoodRepository.findById(id).get();
    }

    public Order updateById(long id, Order order) {
        Order findOrder = getById(id);
        findOrder.update(order);

        return fastFoodRepository.save(findOrder);
    }
}
