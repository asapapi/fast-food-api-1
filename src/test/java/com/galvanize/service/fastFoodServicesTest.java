package com.galvanize.service;


import com.galvanize.entities.Order;
import com.galvanize.repositories.FastFoodRepository;
import com.galvanize.services.FastFoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class fastFoodServicesTest {

    @Autowired
    FastFoodRepository fastFoodRepository;


    @Test
    void createAndOrder() {

        Order order = new Order("Asahi", "BigAzzBurger");
        FastFoodService fastFoodService = new FastFoodService(fastFoodRepository);
        assertNotNull(fastFoodService.createOrder(order).getId());

    }

    @Test
    void getAllOrders() {
        FastFoodService fastFoodService = new FastFoodService(fastFoodRepository);
        Order order = new Order("Asahi", "BigAzzBurger");
        Order order2 = new Order("Asahi", "BigAzzBurger");
        Order order3 = new Order("Asahi", "BigAzzBurger");
        fastFoodService.createOrder(order);
        fastFoodService.createOrder(order2);
        fastFoodService.createOrder(order3);
        List<Order> actual = fastFoodService.getAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0).getCustomerName(), order.getCustomerName());
        assertEquals(actual.get(1).getCustomerName(), order2.getCustomerName());
        assertEquals(actual.get(2).getCustomerName(), order3.getCustomerName());


    }

    @Test
    void getById() {
        FastFoodService fastFoodService = new FastFoodService(fastFoodRepository);
        Order order = new Order("Asahi", "BigAzzBurger");
        Order expected = fastFoodService.createOrder(order);
        assertEquals(expected, fastFoodService.getById(expected.getId()));


    }

    @Test
    void updateById() {
        FastFoodService fastFoodService = new FastFoodService(fastFoodRepository);
        Order order = new Order("Asahi", "hotdog");
        Order expected = fastFoodService.createOrder(order);
        Order modifyOrder = new Order();
        modifyOrder.setNote("round1");
        expected.setNote(modifyOrder.getNote());
        assertEquals(expected,fastFoodService.updateById(expected.getId(),modifyOrder));
    }

}
