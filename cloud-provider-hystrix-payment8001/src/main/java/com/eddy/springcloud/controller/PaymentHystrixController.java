package com.eddy.springcloud.controller;

import com.eddy.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    HystrixPaymentService payMentService;

    @GetMapping("hystrix/provider/getOk")
    public String getOk(){
        log.info("getOk");
        return payMentService.getOk();
    }

    @GetMapping("hystrix/provider/getNotOk")
    public String getNotOk()
    {
        log.info("getNotOk");
        return payMentService.getNotOk();
    }

    @GetMapping("hystrix/provider/paymentCircuitBreaker")
    public String paymentCircuitBreaker(int id)
    {
        log.info(" paymentCircuitBreaker~~~~ ");
        return payMentService.paymentCircuitBreaker(id);
    }
}
