package com.evg.orders.rest;

import com.evg.orders.model.Order;
import com.evg.orders.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Slf4j
public class Orders {

    private final ObjectMapper ignoringObjectMapper;
    private final OrderService orderService;

    @GetMapping("/info")
    public String getInfo() {
        return "This is an Orders Microservice";
    }

    @PutMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            return new ResponseEntity<>("Created Order: " +
                    ignoringObjectMapper.writeValueAsString(orderService.createOrder(order)), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>("Order was not created: " + Arrays.toString(e.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrdersByClient")
    public ResponseEntity<String> getOrdersByClient(Long clientId) {
        try {
            return new ResponseEntity<>(
                    ignoringObjectMapper.writeValueAsString(orderService.getOrdersByClientId(clientId)), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>("Order was not found: " + Arrays.toString(e.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<String> getAllOrders() {
        try {
            List<Order> orders = orderService.getAll();
            return new ResponseEntity<>(
                    ignoringObjectMapper.writeValueAsString(orders), HttpStatus.OK );
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Order was not found: " + Arrays.toString(e.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
