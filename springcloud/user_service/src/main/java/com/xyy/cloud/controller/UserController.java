package com.xyy.cloud.controller;

import com.xyy.cloud.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/{id}")
    public List<User> getUser(@PathVariable Long id) {
        List<User> list =new ArrayList<>();
        User user =new User();
        user.setName("小亚亚");
        user.setAge(20);
        user.setSex("男");
        list.add(user);
        LOGGER.info("根据id获取用户信息，用户名称为：{}",user.getName());
        return list;
    }
}
