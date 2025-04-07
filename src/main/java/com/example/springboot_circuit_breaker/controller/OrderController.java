package com.example.springboot_circuit_breaker.controller;

import com.example.springboot_circuit_breaker.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value ="order")
    public String testCircuitBreaker() {
        return orderService.serviceFail();
    }
}
