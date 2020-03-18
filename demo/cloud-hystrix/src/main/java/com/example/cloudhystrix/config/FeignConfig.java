package com.example.cloudhystrix.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "eureka-client2",fallback = FeignImpl.class)
public interface FeignConfig  {


    @GetMapping("/say/hello")
    public String say();

    }
