package com.lance.demo.springcloud.server.sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.TraceRunnable;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo-spring-cloud/runner")
public class RunnableController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Tracer tracer;

    @GetMapping("/zipkin")
    public String zipkin() {
        String serviceA = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/runner/a", String.class);
        return "zipkin " + serviceA;
    }

    @GetMapping("/a")
    public String serviceA() {
        String serviceB = restTemplate.getForObject("http://localhost:8111/demo-spring-cloud/runner/b", String.class);
        return " service a " + serviceB;
    }

    @GetMapping("/b")
    public String serviceB() {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }

            @Override
            public String toString() {
                return "runner";
            }
        };
        Runnable traceRunner = new TraceRunnable(tracer, null, runner, "service b runner");
        new Thread(traceRunner).start();
        return " service b";
    }


}
