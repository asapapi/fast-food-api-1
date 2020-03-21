package com.galvanize.service;


import com.galvanize.entities.Order;
import com.galvanize.repositories.FastFoodRepository;
import com.galvanize.services.FastFoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class fastFoodServicesTest {

   @Autowired
   FastFoodRepository fastFoodRepository;


   @Test
    void createAndOrder(){

       Order order = new Order("Asahi", "BigAzzBurger");
       FastFoodService fastFoodService = new FastFoodService(fastFoodRepository);
       assertNotNull(fastFoodService.createOrder(order).getId());

   }


}
