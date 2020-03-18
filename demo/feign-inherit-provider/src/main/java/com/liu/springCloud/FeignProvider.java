package com.liu.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignProvider {

    public static  void main(String []args){
        SpringApplication.run(FeignProvider.class,args);
    }
}
