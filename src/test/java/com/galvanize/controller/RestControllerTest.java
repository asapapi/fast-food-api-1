package com.galvanize.controller;

import com.galvanize.services.FastFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class RestControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    FastFoodService fastFoodService;

//    @Test
//    void createOrder throws Exception(){
//        Order order = new Order("asahi", "BigAzzBurger");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(order);
//
//        order.setId(1L);
//
//        when(fastFoodService.createOrder(order).thenReturn(order));
//        mvc.perform(post("/api/orders").content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists());
//
//
//    }
}
