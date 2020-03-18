package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.service.MyRuleDao;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MyRuleDaoImpl implements MyRuleDao {

    AtomicInteger atomicInteger=new AtomicInteger(0);
    public ServiceInstance getServiceInstance(List<ServiceInstance> list) { 
        Integer currIndex=getIndex(list.size());
        ServiceInstance serviceInstance=list.get(currIndex%list.size());
        return serviceInstance;
    }

    private Integer getIndex(int size) {
        int cuurrNum;
        int next;
        do{
            cuurrNum=atomicInteger.get();
            next=cuurrNum>=10?1:cuurrNum+1;
        }while (!atomicInteger.compareAndSet(cuurrNum,next));
        return next;
    }
}
