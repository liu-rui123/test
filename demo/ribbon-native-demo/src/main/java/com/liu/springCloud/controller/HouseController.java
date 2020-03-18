package com.liu.springCloud.controller;

import com.liu.springCloud.pojo.HouseInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HouseController {


    @GetMapping("/house/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return new HouseInfo(name);
    }

    @GetMapping("/house/data/{name}")
    public String getRestData(@PathVariable("name") String name){
        return name;
    }
    @PostMapping("/house/save")
    public Long addData(@RequestBody HouseInfo houseInfo){
        return  1L;
    }
}
