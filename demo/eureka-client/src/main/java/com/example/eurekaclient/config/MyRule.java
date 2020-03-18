package com.example.eurekaclient.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule implements IRule{

    private ILoadBalancer iLoadBalancer;
    @Override
    public Server choose(Object o) {
        System.out.println(o+"-----------------------------------------------------");
        List<Server> allServers = iLoadBalancer.getAllServers();

        for (Server se:
             allServers) {
            System.out.println(se.getHost()+"--"+se.getHostPort());
        }
       /* if(true){
            throw  new RuntimeException("")
        }*/
        return allServers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {

        return iLoadBalancer;
    }
}
