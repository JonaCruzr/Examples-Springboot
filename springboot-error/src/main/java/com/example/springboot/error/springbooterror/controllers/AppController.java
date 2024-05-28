package com.example.springboot.error.springbooterror.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        System.out.println(Integer.parseInt("10a"));
        return "200 OK";
    }

}
