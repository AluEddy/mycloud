package com.eddy.springcloud.openfeign;

import com.eddy.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PayMentFeign {
    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id")Long id);
    @GetMapping("/payment/timeOut")
    public CommonResult timeOut();
}
