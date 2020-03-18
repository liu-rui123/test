package com.liu.springCloud.controller;

import com.liu.springCloud.pojo.HouseInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HouseClientController {

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/call/data",produces = "application/json")
    @ResponseBody
    public HouseInfo getData(@RequestParam("name") String name){


        return restTemplate.getForObject("http://localhost:8080/house/data?name="+name,HouseInfo.class);
    }

    @GetMapping("/call/data/{name}")
    public String getRestData(@PathVariable("name") String name){

        return restTemplate.getForObject("http://localhost:8080/house/data/"+name,String.class);
    }
    @GetMapping("/call/dataEntity")
    public HouseInfo getDatas(@RequestParam("name") String name){
        ResponseEntity<HouseInfo> forEntity = restTemplate.getForEntity("http://localhost:8080/house/data?name=" + name, HouseInfo.class);
        if(forEntity.getStatusCodeValue()==200){
            return forEntity.getBody();
        }
        return null;
    }
    @GetMapping("/call/save")
    public Long addDatas(){
        HouseInfo houseInfo=new HouseInfo();
        return restTemplate.postForObject("http://localhost:8080/house/save",houseInfo,Long.class);
    }
}
