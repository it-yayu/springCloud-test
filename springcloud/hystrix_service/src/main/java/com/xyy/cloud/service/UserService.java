package com.xyy.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.xyy.cloud.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public List<User> getUser(@PathVariable Long id){
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", List.class, id);

    }

    @HystrixCommand(fallbackMethod = "getDefaultUser2", ignoreExceptions = {NullPointerException.class})
    public List<User> getUserException(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", List.class, id);
    }




    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getDefaultUser", commandKey = "getUserCache")
    public List<User> getUserCache(Long id) {
        LOGGER.info("getUserCache id:{}", id);
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", List.class, id);
    }


    /**
     * 为缓存生成key的方法
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }

    public List<User> getDefaultUser2(@PathVariable Long id, Throwable e) {
        List userList=new ArrayList();
        User user=new User();
        user.setAge(20);
        user.setName("小绿");
        user.setSex("女");
        userList.add(user);
        return userList;
    }





    public List<User> getDefaultUser(@PathVariable Long id) {
       List userList=new ArrayList();
       User user=new User();
       user.setAge(20);
       user.setName("小红");
       user.setSex("女");
       userList.add(user);
        return userList;
    }
}
