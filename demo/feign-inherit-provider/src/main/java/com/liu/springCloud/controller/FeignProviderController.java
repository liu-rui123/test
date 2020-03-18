package com.liu.springCloud.controller;

import com.liu.springCloud.config.FeignConfig;
import com.liu.springCloud.config.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignProviderController implements FeignConfig {
    @Override
    public String say() {
        return "接口定义模式";
    }

    @Override
    public String many(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        return "用户名："+name+"\tage:"+age;
    }

    @Override
    public String add(@RequestBody User user) {
        return "用户添加成功："+user.getName();
    }
}
