package com.liu.springCloud.dao;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.List;

public class MyHyStrixDao2 extends HystrixCommand<List<String>>{

       private List<String> name;
    public MyHyStrixDao2( List<String> name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("grundId"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ground2")));
        this.name=name;
    }

    @Override
    protected  List<String> run() throws Exception {
        String str="";
        for (String s:name) {
            str+=s+"---";
        }
        System.out.println(str+"---"+name.size());
        return name;
    }
}
