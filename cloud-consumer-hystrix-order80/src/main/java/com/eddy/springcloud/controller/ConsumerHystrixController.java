package com.eddy.springcloud.controller;

import com.eddy.springcloud.openfeign.HystrixPaymentFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultHandler")
public class ConsumerHystrixController {
    @Resource
    private HystrixPaymentFeign hystrixPaymentFeign;

    @HystrixCommand
    @GetMapping("hystrix/consumer/getOk")
    public String getOk(){
        /*int a = 10/0;
        return null;*/
        return hystrixPaymentFeign.getOk();
    }

    @HystrixCommand(defaultFallback = "getNotOkHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("hystrix/consumer/getNotOk")
    public String getNotOk(){
        return hystrixPaymentFeign.getNotOk();
    }
    public String getNotOkHandler(){
        return "消费者80出错~~";
    }

    public String defaultHandler(){
        return "消费者80出错~~  defaultHandler~~~";
    }

}

