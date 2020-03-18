package com.example.eurekaclient.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyRuleDao {
    ServiceInstance getServiceInstance(List<ServiceInstance> list);
}
