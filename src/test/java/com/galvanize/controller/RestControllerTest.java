package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Order;
import com.galvanize.services.FastFoodService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class RestControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    FastFoodService fastFoodService;

    @Test
    void createOrder() throws Exception {
        Order order = new Order("asahi", "BigAzzBurger");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(order);

        order.setId(1L);

        when(fastFoodService.createOrder(ArgumentMatchers.any(Order.class))).thenReturn(order);
        mvc.perform(post("/api/orders").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());


    }
}
