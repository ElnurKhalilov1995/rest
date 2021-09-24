package com.example.demo.controller;

import com.example.demo.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/say-hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/say-bye")
    public String sayBye() {
        return "Bye";
    }
}
