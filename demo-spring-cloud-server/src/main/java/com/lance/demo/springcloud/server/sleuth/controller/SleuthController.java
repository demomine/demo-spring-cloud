package com.lance.demo.springcloud.server.sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo-spring-cloud/sleuth")
public class SleuthController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zipkin")
    public String zipkin() {
        String serviceA = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/a", String.class);
        return "zipkin " + serviceA;
    }

    @GetMapping("/a")
    public String serviceA() {
        String serviceB = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/b", String.class);
        String serviceC = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/c", String.class);
        return " service a " + serviceB + serviceC;
    }

    @GetMapping("/b")
    public String serviceB() {
        String serviceD = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/d", String.class);
        return " service b " + serviceD;
    }

    @GetMapping("/c")
    public String serviceC() {
        String serviceD = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/d", String.class);
        return " service c " + serviceD;
    }

    @GetMapping("/d")
    public String  serviceD() {
        serviceBefore("dd");
        return " service d ";
    }

    @ContinueSpan(log = "continue service d")
    private String serviceBefore(@SpanTag("serviceD") String dd) {
        return serviceLast(dd);
    }


    @NewSpan("service last")
    private String serviceLast(String dd) {
        return dd;
    }
}
