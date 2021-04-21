package com.eddy.springcloud.openfeign;

import com.eddy.springcloud.openfeign.hytrix.PaymentFeignhystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignhystrix.class)
public interface HystrixPaymentFeign {
    @GetMapping("hystrix/provider/getOk")
    public String getOk();

    @GetMapping("hystrix/provider/getNotOk")
    public String getNotOk();
}
