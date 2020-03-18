package com.example.eurekaclient.controller;

import com.example.eurekaclient.service.MyRuleDao;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EurkeaClientController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    MyRuleDao dao;
    @GetMapping("/client")
    public String say(){
        return restTemplate.getForObject("http://EUREKA-CLIENT2/say/hello",String.class);
    }

    @GetMapping("/client2")
    public Object sayMyRule(){
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-CLIENT2");

           ServiceInstance serviceInstance = dao.getServiceInstance(instances);
        System.out.println(serviceInstance.getUri());
        return restTemplate.getForObject(serviceInstance.getUri()+"/say/hello",String.class);
    }
}
