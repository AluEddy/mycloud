package com.eddy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSeverMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSeverMain7001.class,args);
    }
}
