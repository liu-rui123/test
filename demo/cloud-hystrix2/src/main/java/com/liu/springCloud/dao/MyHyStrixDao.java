package com.liu.springCloud.dao;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import sun.dc.pr.PRError;

public class MyHyStrixDao extends HystrixCommand<String> {
    private String name;
    public MyHyStrixDao(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("grundId"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ground2")));
        this.name=name;
    }

    @Override
    protected String run() throws Exception {
        return "当前用户姓名："+name;
    }
}
