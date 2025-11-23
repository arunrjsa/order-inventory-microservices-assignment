package com.example.orderservice;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderServiceApplicationTests {

        @Mock
        private OrderRepository repository;

        @Mock
        private RestTemplate restTemplate;

        @InjectMocks
        private OrderService service;

        @Test
        void testPlaceOrder() {
            when(restTemplate.postForObject(anyString(), eq(null), eq(String.class)))
                    .thenReturn("Inventory updated");

            Order order = new Order(null, "P1", 5, LocalDate.now());
            when(repository.save(any(Order.class))).thenReturn(order);

            Order result = service.placeOrder("P1", 5);
            assertEquals("P1", result.getProductId());
        }
    }
