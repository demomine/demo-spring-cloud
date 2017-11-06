package com.lance.demo.springcloud.server.controller;

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

    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private final ConsulProperties consulProperties;

    @Autowired
    public ConsulController(ConsulService consulService, ConsulProperties consulProperties) {
        this.consulService = consulService;
        this.consulProperties = consulProperties;
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
}
