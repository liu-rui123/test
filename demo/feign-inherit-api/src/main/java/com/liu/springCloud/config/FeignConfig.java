package com.liu.springCloud.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "feign-inherit-provider",configuration = FeignConfigLogger.class)
public interface FeignConfig {
    @GetMapping("/say/hello")
    public String say();

    @GetMapping("/say/many")
    public String many(@RequestParam("name") String name,@RequestParam("age") Integer age);

    @PostMapping("/say/add")
    public String add(@RequestBody  User user);
}
