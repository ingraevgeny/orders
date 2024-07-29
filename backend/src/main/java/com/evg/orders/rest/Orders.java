package com.evg.orders.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Orders {
    @GetMapping("/info")
    public String getInfo() {
        return "This is a Orders Microservice";
    }
}
