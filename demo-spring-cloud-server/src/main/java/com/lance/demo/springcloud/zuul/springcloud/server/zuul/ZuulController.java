package com.lance.demo.springcloud.zuul.springcloud.server.zuul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuul")
public class ZuulController {

    @GetMapping("/hello")
    public String hello() {
        return "hello zuul";
    }
}
