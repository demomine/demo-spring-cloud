package com.lance.demo.springcloud.client.controller;

import com.lance.demo.springcloud.client.service.DemoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class DemoClientController {
    private final DemoClientService demoClientService;

    @Autowired
    public DemoClientController(DemoClientService demoClientService) {
        this.demoClientService = demoClientService;
    }

    @GetMapping("/demo")
    public String demo(boolean flag) {
        return demoClientService.demoHystrix(flag);
    }

}
