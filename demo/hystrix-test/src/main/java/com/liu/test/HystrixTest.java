package com.liu.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.List;

public class HystrixTest extends HystrixCommand<List<String>>{
    private List<String> name;
    public HystrixTest(List<String> name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("groudId"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("groundIds")));
        this.name=name;
    }

    @Override
    protected List<String> run() throws Exception {

            System.out.println(name.size()+"----");

        return this.name;
    }

}
