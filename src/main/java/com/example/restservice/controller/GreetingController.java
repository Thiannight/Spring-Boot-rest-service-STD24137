package com.example.restservice.controller;

import com.example.restservice.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(
                counter.incrementAndGet(),
                "Hello " + name
        );
    }
}