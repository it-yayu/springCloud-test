package com.xyy.cloud.service;

import com.xyy.cloud.pojo.User;
import com.xyy.cloud.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-service",fallback = UserFallbackService.class )
public interface UserService {

    @GetMapping("/user/{id}")
    List<User> getUser(@PathVariable Long id);
}

