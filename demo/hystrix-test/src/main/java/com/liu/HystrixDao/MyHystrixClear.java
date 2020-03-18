package com.liu.HystrixDao;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;

public class MyHystrixClear extends HystrixCommand<String> {
    private String name;
    private static final HystrixCommandKey groud = HystrixCommandKey.Factory.asKey("groud");
    public MyHystrixClear(String setter) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("groud2"))
        .andCommandKey(groud));
        name=setter;
    }

    public   static  void flushCache(String name){
        HystrixRequestCache.getInstance(groud,
                HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }
    int i;
    @Override
    protected String run() throws Exception {
        System.out.println("test2----------------");
        i++;
        return this.name+"--"+i+"--"+Thread.currentThread().getName();
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(name);
    }
}
