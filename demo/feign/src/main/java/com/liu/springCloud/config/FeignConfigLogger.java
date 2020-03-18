package com.liu.springCloud.config;


import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rx.annotations.Beta;

import java.util.Base64;

@Configuration
public class FeignConfigLogger {

    @Bean
    Logger.Level feignLoggin(){
        return Logger.Level.FULL;
    }


    //修改为原生feign所以不支持spring注解。。导致运行时报错但是可以单独使用
   /* @Bean
    Contract contract(){
        return new feign.Contract.Default();
    }*/

  /* @Bean
    public FeignAuthRequestConifg requestConifg(){
       return new FeignAuthRequestConifg();
   }*/


    //设置请求超时时间。。。入过provder提供微服务请求时间过长则会跑出异常，，所以修改默认连接超时时间
    @Bean
    Request.Options options(){
        //第一个参数是请求连接时长 第二个参数是获取超时时长
      return new Request.Options(5000,10000);
  }

  //书上讲的没头没尾我也不清楚
 /* @Bean
    public Decoder  decoder(){
        return new MyDecoder()
  }*/
}
