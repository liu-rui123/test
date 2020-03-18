package com.example.cloudhystrix.controller;

import com.example.cloudhystrix.config.FeignConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class HystrixController {

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/say/hystrix")
    @HystrixCommand(fallbackMethod = "error")
    public String sayHystrix(){
        return restTemplate.getForObject("http://eureka-client2/say/hello",String.class);
    }
    public String error(Throwable throwable){
        return "error"+throwable.getMessage();
    }

    @GetMapping("/say/timeout")
    @HystrixCommand(fallbackMethod = "time",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String timeout(Integer id){
        if(id<0){
            throw new RuntimeException("输入数字需要大于0");
        }
        return "timeout1"+Thread.currentThread().getName();
    }
    public String time(Integer id){
        return "timeout"+Thread.currentThread().getName();
    }
    @Resource
    private FeignConfig feignConfig;
    @GetMapping("/say/hystrix2")
    public String fe(){
        return feignConfig.say();
    }
}
