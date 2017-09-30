package com.lance.demo.springcloud.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class DemoClientService {
    @HystrixCommand(fallbackMethod = "failDemo")
    public String demoHystrix(boolean flag) {
        if (flag) {
            return "hello hystrix";
        }
        return failDemo(false);
    }

    public String failDemo(boolean flag) {
        return "error hystrix";
    }
}
