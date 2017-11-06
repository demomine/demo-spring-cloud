package com.lance.demo.springcloud.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ConsulService {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public ConsulService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public String getService(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if (CollectionUtils.isEmpty(instances)) {
            throw new RuntimeException("service not found");
        }
        ServiceInstance serviceInstance = instances.get(0);
        return serviceInstance.getUri().toString();
    }
}
