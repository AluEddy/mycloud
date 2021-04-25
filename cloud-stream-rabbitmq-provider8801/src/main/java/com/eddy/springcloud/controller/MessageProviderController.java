package com.eddy.springcloud.controller;

import com.eddy.springcloud.Service.IMessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("sendMessage")
    public void sendMessage(){
        iMessageProvider.send();
    }
}
