package com.lance.demo.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("demo-spring-cloud-consul")
public interface ConsulInterface {
    @RequestMapping(method = RequestMethod.GET,value = "/spring-cloud-demo/consul/hello")
    String demo();
}
