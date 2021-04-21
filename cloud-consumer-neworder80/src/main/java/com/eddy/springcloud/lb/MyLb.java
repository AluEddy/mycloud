package com.eddy.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *  手写Ribbon 的轮询机制(对要调用的服务数取余,cas算法设置成功就返回余数 去第余数个机器)
 */
@Component
@Slf4j
public class MyLb implements LoadBlancer{

    @Resource
    private DiscoveryClient discoveryClient;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        for (;;){
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0: current+1;
            log.info(next+"");
            if (this.atomicInteger.compareAndSet(current,next)){
                log.info("next****************"+next);
                return next;
            }

        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> ServiceInstances) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        int target = getAndIncrement()%instances.size();
        return instances.get(target);
    }
}
