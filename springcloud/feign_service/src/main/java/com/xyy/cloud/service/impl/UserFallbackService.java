package com.xyy.cloud.service.impl;

import com.xyy.cloud.pojo.User;
import com.xyy.cloud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFallbackService implements UserService {
    @Override
    public List<User> getUser(Long id) {
        List userList=new ArrayList();
        User user=new User();
        user.setAge(20);
        user.setName("小黑");
        user.setSex("女");
        userList.add(user);
        return userList;
    }
}
