package com.lance.demo.springcloud.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;

@ConfigurationProperties(prefix = "consul")
public class ConsulProperties {
    @Valid
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
