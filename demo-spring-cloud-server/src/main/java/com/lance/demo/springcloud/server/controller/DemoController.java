package com.lance.demo.springcloud.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${demo.name}")
    private String name;

    @Value("${demo.test}")
    private String test;

    @GetMapping("/config")
    public String config() {
        return name + test;
    }
}
