package springcloud.Controller;

import com.eddy.springcloud.entity.CommonResult;
import com.eddy.springcloud.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PayMentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PayMentController {

    @Resource
    PayMentService payMentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody PayMent payMent){
        int i = payMentService.creat(payMent);
        log.info("i===="+i);
        if (i>0){
            return new CommonResult(200,"success",i);
        }else {
            return new CommonResult(444,"fail",i);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        PayMent payMent = payMentService.getById(id);
        if (payMent!=null){
            return new CommonResult(200,"success==+serverPort:"+serverPort,payMent);
        }else {
            return new CommonResult(444,"fail==+serverPort:"+serverPort);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String string : services){
            log.info("######"+string);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getInstanceId()+"\t"
                    +serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
