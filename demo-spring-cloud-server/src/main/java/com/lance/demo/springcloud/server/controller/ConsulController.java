package com.lance.demo.springcloud.server.controller;

import com.lance.demo.springcloud.client.ConsulInterface;
import com.lance.demo.springcloud.server.config.ConsulProperties;
import com.lance.demo.springcloud.server.service.ConsulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-cloud-demo/consul")
public class ConsulController {
    private final ConsulService consulService;
    private final ConsulProperties consulProperties;
    private final ConsulInterface consulInterface;
    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    public ConsulController(ConsulService consulService, ConsulProperties consulProperties, ConsulInterface consulInterface) {
        this.consulService = consulService;
        this.consulProperties = consulProperties;
        this.consulInterface = consulInterface;
    }

    @RequestMapping("/hello")
    public String demo() {

        return "hello consul";
    }
    @RequestMapping("/service")
    public String service() {
        return consulService.getService(serviceName);
    }

    @RequestMapping("/config")
    public String config() {
        return consulProperties.getName();
    }

    @RequestMapping("/feign")
    public String feign() {
        return consulInterface.demo();
    }
}
