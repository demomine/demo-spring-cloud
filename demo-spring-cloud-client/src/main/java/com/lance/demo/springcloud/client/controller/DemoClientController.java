package com.lance.demo.springcloud.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class DemoClientController {

    @GetMapping("/demo")
    public String demo() {
        return "hello world";
    }
}
