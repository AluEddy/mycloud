package com.eddy.springcloud;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class ConfigServerMain3344 {
    public static void main(String[] args) {
        log.info("aaaaa");
        SpringApplication.run(ConfigServerMain3344.class,args);
    }
}
