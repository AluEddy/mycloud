package com.eddy.springcloud.openfeign.hytrix;

import com.eddy.springcloud.openfeign.HystrixPaymentFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignhystrix implements HystrixPaymentFeign {
    @Override
    public String getOk() {
        return "8001异常   getOk";
    }

    @Override
    public String getNotOk() {
        return "8001异常   getNotOk";
    }
}
