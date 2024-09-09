package com.evg.orders.service;

import com.evg.orders.dao.OrderRepository;
import com.evg.orders.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrders(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId).orElse(new ArrayList<>());
    }

}
