package com.example.springboot_circuit_breaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @CircuitBreaker(name="order-service", fallbackMethod = "myFallBack")
    public String serviceFail() {
        if(Math.random() <0.5) {
            throw new RuntimeException("External Service Failed");
        }
        return "Circuit Service access";
    }

    public String myFallBack(RuntimeException  e) {
        System.out.println(e);
         return "FallBack method";
    }
}
