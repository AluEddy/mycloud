package com.eddy.springcloud.controller;

import com.eddy.springcloud.entity.CommonResult;
import com.eddy.springcloud.entity.PayMent;
import com.eddy.springcloud.openfeign.PayMentFeign;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PayMentFeign payMentFeign;

    @GetMapping("/consumer/feign/get/{id}")
    CommonResult get(@PathVariable("id")Long id){
        return payMentFeign.get(id);
    }

     @GetMapping("/consumer/feign/timeOut")
    CommonResult timeOut(){
        return payMentFeign.timeOut();
    }
}
