package com.liu.springCloud.dao;

import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyHyStrixCollapser extends HystrixCollapser<List<String>,String,String> {


    private String name;
    public MyHyStrixCollapser(String name){
        super(HystrixCollapser.Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("MyHyStrixCollapser"))
        .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(200)));
        this.name=name;
    }
    /**
     * 入参值
     * @return
     */
    @Override
    public String getRequestArgument() {
        return name;
    }

    /**
     * 处理请求合并接口
     * @param collection
     * @return
     */
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> collection) {
        List<String> list=new ArrayList<>();
        for (CollapsedRequest<String,String> c:
            collection ) {
            list.add(c.getArgument());
        }

        return new MyHyStrixDao2(list);
    }

    /**
     * 分配资源接口
     * @param strings
     * @param collection
     */
    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, String>> collection) {
        int count=0;
        for (CollapsedRequest<String, String> c:
             collection) {
            c.setResponse(strings.get(count++));
        }
    }
}
