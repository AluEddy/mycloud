package com.eddy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("provider/payment/{id}")
    public String getById(@PathVariable("id") int id){
        return "provider payment === "+serverPort+"  "+id;
    }
}
