package com.eddy.springcloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosConsumerController {

    @Value("${service.url}")
    private String serverurl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/{id}")
    public String getById(@PathVariable("id") int id){
        return restTemplate.getForObject(serverurl+"/provider/payment/"+id,String.class);
    }
}
