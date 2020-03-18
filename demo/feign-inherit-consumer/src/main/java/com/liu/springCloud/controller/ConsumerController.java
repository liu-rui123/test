package com.liu.springCloud.controller;

import com.liu.springCloud.config.FeignConfig;
import com.liu.springCloud.config.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {


    @Resource
    private FeignConfig config;

    @GetMapping("/feign/say")
    public String say(){
        return config.say();
    }
    @GetMapping("/feign/many")
    public String many(@RequestParam("name") String name,@RequestParam("age") Integer age){
        return config.many(name,age);
    }
    @GetMapping("/feign/add")
    public String add(){
        User user=new User();
        user.setName("睿哥");
        user.setAge(55);
        return  config.add(user);
    }

}
