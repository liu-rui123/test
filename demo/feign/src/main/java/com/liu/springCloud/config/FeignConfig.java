package com.liu.springCloud.config;

import com.liu.springCloud.springCloud.entities.CommonResult;
import com.liu.springCloud.springCloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "EUREKA-CLIENT2",configuration = FeignConfigLogger.class)
public interface FeignConfig {
    @GetMapping("/say/hello")
    public String say();
    @GetMapping("/say/all")
    public CommonResult all();


    @PostMapping("/say/add")
    public CommonResult add(@RequestBody Payment payment);


    @PostMapping("/say/update")
    public CommonResult update(@RequestBody Payment payment);

    @GetMapping("/say/delete")
    public CommonResult delete(@RequestParam("id") Long id);

    @GetMapping("/say/getName")
    public CommonResult getName(@RequestParam("name") String name);
}
