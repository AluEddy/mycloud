package com.eddy.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSeverMain7001 {
    public static void main(String[] args) {
        System.out.println("qaaaaa");
        SpringApplication.run(EurekaSeverMain7001.class,args);
    }
}
