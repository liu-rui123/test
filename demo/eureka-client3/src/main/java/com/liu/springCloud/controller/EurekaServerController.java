package com.liu.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServerController {


    @Value("${server.port}")
    private String port;
    @GetMapping("/say/hello")
    public String say(){
        System.out.println("=========================");
        return "hello port:"+port;
    }
}
