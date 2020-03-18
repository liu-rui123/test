package com.liu.springCloud;

import com.liu.springCloud.dao.MyHyStrixCollapser;
import com.liu.springCloud.dao.MyHyStrixDao;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class test {
    public static void main(String []args) throws ExecutionException, InterruptedException {
     /*   MyHyStrixDao java = new MyHyStrixDao("java");
        Future<String> queue = java.queue();
        try {
            String s = queue.get();
            System.out.println(s);
            MyHyStrixDao html = new MyHyStrixDao("html");
           s = html.execute();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        MyHyStrixCollapser java = new MyHyStrixCollapser("java");
        Future<String> queue = java.queue();
        MyHyStrixCollapser java1 = new MyHyStrixCollapser("html");
        Future<String> queue1 = java1.queue();
        String s = queue.get();
        String s1 = queue1.get();
        //System.out.println(s+"----"+s1);



        //   hystrixRequestContext.close();
        hystrixRequestContext.shutdown();


    }
}
