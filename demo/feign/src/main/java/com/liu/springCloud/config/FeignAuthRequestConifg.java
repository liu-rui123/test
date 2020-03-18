package com.liu.springCloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component  //提供自定义拦截器只需要实现RequestInterceptor然后注入到spring容器当中总的来说比较简单
public class FeignAuthRequestConifg implements RequestInterceptor {
    @Override
    //请求到达方法提供者之前调用
    public void apply(RequestTemplate requestTemplate) {

     System.out.println("---1231");
    }
}
