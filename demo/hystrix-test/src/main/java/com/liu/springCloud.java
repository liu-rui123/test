package com.liu;

import com.liu.HystrixDao.MyHystrixClear;
import com.liu.HystrixDao.MyHystrixDai;
import com.liu.test.MyHystrixCollapser;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class springCloud {
    public static void  main(String []args) throws ExecutionException, InterruptedException {
        //缓存需要设置一个生命周期，其周期为9-14行（如下代码为列）
      /*  HystrixRequestContext e= HystrixRequestContext.initializeContext();
        String zahngsan = new MyHystrixDai("zahngsan").execute();
            System.out.println(zahngsan);
         zahngsan = new MyHystrixDai("zahngsan").execute();
        System.out.println(zahngsan);
            e.shutdown();*/
      //缓存的key就是参数的值，而缓存的value是方法run的返回值
       /* HystrixRequestContext e= HystrixRequestContext.initializeContext();
        String zahngsan = new MyHystrixClear("zahngsan").execute();
        System.out.println(zahngsan);
        MyHystrixClear.flushCache("zahngsan");
        zahngsan = new MyHystrixClear("zahngsan").execute();
        System.out.println(zahngsan);
        e.shutdown();*/
        HystrixRequestContext e= HystrixRequestContext.initializeContext();
        MyHystrixCollapser hystrixCollapser=new MyHystrixCollapser("java");
        MyHystrixCollapser hystrixCollapser2=new MyHystrixCollapser("html");
        Future<String> queue = hystrixCollapser.queue();
        Future<String> queue1 = hystrixCollapser2.queue();
        String s1 = queue.get();
        String s = queue1.get();

        e.close();

    }
}
