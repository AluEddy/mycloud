package com.eddy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentService {

    public String getOk(){
        int a = 10/0;
        return "线程池：  "+Thread.currentThread().getName()+"  getOk"+"\t"+"O(∩_∩)O哈哈~";
    }

    //服务降级
    @HystrixCommand(defaultFallback = "getNotOkHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String getNotOk(){
//        int a = 10/0;
        int n = 3;
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName()+"  getNotOk"+"\t"+"O(∩_∩)O哈哈~";
    }
    public String getNotOkHandler(){
        return "线程池：  "+Thread.currentThread().getName()+"  getNotOk"+"\t"+"(灬ꈍ ꈍ灬)555~";
    }

    //服务熔断
    @HystrixCommand(defaultFallback = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(int id){
        if (id<0){
            throw new RuntimeException("id不可为负数哦~~~~o(╥﹏╥)o");
        }
        String time = IdUtil.simpleUUID();
        return "线程池：  "+Thread.currentThread().getName()+"  调用成功 流水号"+"\t"+time+"  O(∩_∩)O哈哈~";
    }
    public String paymentCircuitBreaker_fallback(){
        return "id不可为负数哦~~~~稍后再试~~~"+"(灬ꈍ ꈍ灬)555~";
    }
}
