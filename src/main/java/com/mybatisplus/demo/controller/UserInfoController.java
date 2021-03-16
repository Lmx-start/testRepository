package com.mybatisplus.demo.controller;


import com.mybatisplus.demo.entity.UserInfo;
import com.mybatisplus.demo.utils.redis.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-09
 */
@RestController
public class UserInfoController {
      @Autowired
      private RedisTemplate redisTemplate;

      @PostMapping("/set")
      public void set(@RequestBody UserInfo userInfo){
        redisTemplate.opsForValue().set("UserInfo",userInfo);
      }
}
