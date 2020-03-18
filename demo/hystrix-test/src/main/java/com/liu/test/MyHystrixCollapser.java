package com.liu.test;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//第一个参数为处理合并方法的返回的参数继HystrixText的run方法，
//第二个参数为响应给客户端的参数
//第三个参数为用户传进来的入参
public class MyHystrixCollapser extends HystrixCollapser<List<String>,String,String> {

    private String name;
    public MyHystrixCollapser(String name){
        super(HystrixCollapser.Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("MyHystrixCollapser"))
        .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(200)));
        this.name=name;
    }

    /**
     * 用户请求请求入参
     * @return
     */
    @Override
    public String getRequestArgument() {
        return name;
    }

    /**
     * 请求合并的方法
     * 方法入参的意思，即用户多次请求的参数总和
     *
     * @param collection
     * @return
     */
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> collection) {
            List<String> list=new ArrayList<>();
        for (CollapsedRequest<String, String> collapsedRequests:
            collection ) {
            //拿到用户入参信息
            list.add("用户请求--"+collapsedRequests.getArgument());
        }
        return new HystrixTest(list);
    }

    /**
     * 将请求分发说白了就是用户提交的数据是一并返回的
     * 需要把对应的值分配给对应的用户
     * @param strings
     * @param collection
     */
    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, String>> collection) {
        int count=0;
        for (CollapsedRequest<String, String> collections:
             collection) {
            collections.setResponse(strings.get(count++));
        }
    }
}
