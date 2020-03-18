package com.liu.HystrixDao;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyHystrixDai extends HystrixCommand<String> {
    private String name;
    public MyHystrixDai(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("GroudBy"));
        this.name=name;
    }
        private  int i;
    @Override
    protected String run() throws Exception {
        System.out.println("test--------------------");
     //   int i = 1 / 0;
        i++;
        return this.name+"--"+i+"--"+Thread.currentThread().getName();
    }
    protected String getFallback(){
        return "error";
    }
    public String getCacheKey() {
        return name;
    }
}
