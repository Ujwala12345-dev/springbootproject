package com.demo.jwtproj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {

    @GetMapping("/hello")
    public String hello() {
        return "JWT Authentication Success";
    }
}