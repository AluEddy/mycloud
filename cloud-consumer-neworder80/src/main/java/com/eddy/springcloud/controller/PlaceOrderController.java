package com.eddy.springcloud.controller;

import com.eddy.springcloud.entity.CommonResult;
import com.eddy.springcloud.entity.PayMent;
import com.eddy.springcloud.lb.LoadBlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class PlaceOrderController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    LoadBlancer loadBlancer;
    @Resource
    DiscoveryClient discoveryClient;


    String uri = "http://CLOUD-PAYMENT-SERVICE";
//    String uri = "http://localhost:8001";

    @GetMapping("/consumer/payment/create")
    public CommonResult create(PayMent payMent){
        return restTemplate.postForObject(uri+"/payment/create",payMent, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(uri+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return restTemplate.getForObject(uri+"/payment/discovery", Object.class);
    }

    @GetMapping("/consumer/payment/testZipkin")
    public Object testZipkin(){
        return restTemplate.getForObject("http://localhost:8001"+"/payment/testZipkin", Object.class);
    }

    @GetMapping("/consumer/loadBlancer")
    public Object loadBlancer(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBlancer.instances(instances);
        log.info(serviceInstance.getPort()+"");
        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/discovery", Object.class);
    }
}
