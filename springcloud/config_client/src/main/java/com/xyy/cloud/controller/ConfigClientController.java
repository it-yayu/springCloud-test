package com.xyy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
////该注解用于github配置文件修改了后刷新配置文件
//@RefreshScope
//public class ConfigClientController {
//    @Value("${server.discover-list}")
//    private String eurekaInfo;
//    @RequestMapping("/configInfo")
//    public String getInfo(){
//        return eurekaInfo;
//    }
//}
