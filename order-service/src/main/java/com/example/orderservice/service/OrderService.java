package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Order placeOrder(String productId, int quantity) {
        restTemplate.postForObject(
                "http://localhost:8081/inventory/update?productId=" + productId + "&quantity=" + quantity,
                null,
                String.class
        );

        Order order = new Order(null, productId, quantity, LocalDate.now());
        return repository.save(order);
    }
}


