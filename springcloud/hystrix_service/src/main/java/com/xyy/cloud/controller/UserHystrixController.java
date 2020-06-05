package com.xyy.cloud.controller;



import com.xyy.cloud.pojo.User;

import com.xyy.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHystrixController {
    @Autowired
    private UserService userService;

    /**
     * 测试熔断 服务降级演示
     *
     */
    @GetMapping("/testFallback/{id}")
    public List<User> testFallback(@PathVariable Long id){
        return userService.getUser(id);
    }

    /**
     * 使用ignoreExceptions忽略某些异常降级
     */

    @GetMapping("/testException/{id}")
    public List<User> testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    /**
     * Hystrix的请求缓存 使用前后要关闭,使用过滤器
     */
    @GetMapping("/testCache/{id}")
    public List<User> testCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return new ArrayList<>();
    }

}
