package com.evg.orders.service;

import com.evg.orders.model.Order;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    void createOrders(List<Order> orders);
    List<Order> getAll();
    List<Order> getOrdersByClientId(Long clientId);
}
