package com.evg.orders;

import com.evg.orders.model.Order;
import com.evg.orders.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class OrdersBackendApplication {

    private final ObjectMapper ignoringObjectMapper;

    public static void main(String[] args) {
        SpringApplication.run(OrdersBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrderService orderService) {
        return (args) -> {
            List<Order> orders = ignoringObjectMapper.readValue(
                    InputData.orders, new TypeReference<>() {}
            );
            orderService.createOrders(orders);
        };
    }
}
