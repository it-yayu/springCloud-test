package com.xyy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Test {
    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/hh")
    public void test() {
        System.out.println(name);
    }
}
