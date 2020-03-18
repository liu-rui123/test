package com.liu.springCloud.controller;

import com.liu.springCloud.config.FeignConfig;
import com.liu.springCloud.springCloud.entities.CommonResult;
import com.liu.springCloud.springCloud.entities.Payment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FeignController {

    @Resource
    private FeignConfig feignConfig;

    @GetMapping("/feign/say")
    public String say(){
        return feignConfig.say();
    }

    @GetMapping("/say/all")
    public CommonResult<Payment> all(){
        return feignConfig.all();
    }


    @GetMapping("/say/add")
    public CommonResult add( Payment payment){
        return feignConfig.add(payment);
    }


    @GetMapping("/say/update")
    public CommonResult update( Payment payment){
        return feignConfig.update(payment);
    }

    @GetMapping("/say/delete")
    public CommonResult delete(@RequestParam("id") Long id){
        return feignConfig.delete(id);
    }

    @GetMapping("/say/getName")
    public CommonResult<Payment> getName(@RequestParam("name") String name){
        return feignConfig.getName(name);
    }

}
