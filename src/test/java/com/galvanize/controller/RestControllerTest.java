package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Order;
import com.galvanize.entities.Status;
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

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void getAll() throws Exception {
        Order order1 = new Order("asahi", "BigAzzBurger");
        Order order2 = new Order("asahi", "BigAzzBurger");
        ArrayList<Order> expectedOrder = new ArrayList<>();
        expectedOrder.add(order1);
        expectedOrder.add(order2);
        when(fastFoodService.getAll()).thenReturn(expectedOrder);
        mvc.perform(get("/api/orders")).andExpect(status().isOk())
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(expectedOrder.size())))
                .andExpect(jsonPath("$[0].customerName").value(order1.getCustomerName()))
                .andExpect(jsonPath("$[1].customerName").value(order2.getCustomerName()));

    }

    @Test
    void getById() throws Exception {
        Order order = new Order("asahi", "bigAssBurger");
        order.setId(1L);
        when(fastFoodService.getById(1L)).thenReturn(order);
        mvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()))
                .andExpect(jsonPath("$.customerName").value(order.getCustomerName()))
                .andExpect(jsonPath("$.description").value(order.getDescription()));


    }

    @Test
    void updateById() throws Exception {
        Order order = new Order("asahi", "bigAssBurger");
        ObjectMapper mapper = new ObjectMapper();
        order.setId(1L);
        order.setDescription("hes hungry");
        when(fastFoodService.updateById(1,order)).thenReturn(order);
        mvc.perform(put("/api/orders/1").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(order)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()))
                .andExpect(jsonPath("$.customerName").value(order.getCustomerName()))
                .andExpect(jsonPath("$.description").value(order.getDescription()));

    }
}
