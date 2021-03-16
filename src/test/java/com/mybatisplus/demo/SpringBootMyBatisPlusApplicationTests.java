package com.mybatisplus.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.demo.entity.UserInfo;
import com.mybatisplus.demo.mapper.UserInfoMapper;
import com.mybatisplus.demo.utils.redis.RedisTemplate;
import com.mybatisplus.demo.utils.redis.RedisUtil;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBootMyBatisPlusApplicationTests {

    @Autowired()
    UserInfoMapper userInfoMapper;

    @Autowired()
    RedisTemplate redisTemplate;

    @Autowired()
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        //条件构造器
//        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
//        queryWrapper.isNull(false,"ID");
//      List<UserInfo> listInfo=userInfoMapper.selectList(queryWrapper);
        //      for (UserInfo user:listInfo){
//          System.out.println(user.getName());
//      }
//        //新增操作
//        if(userInfoMapper.addUser("xww","123456") == 1){
//            System.out.println("新增成功！");
//        }

//         //写入redis键值,linux写入一样
//         redisUtil.set("passWord","123456");
//         //获取redis键,linux获取一样
//         System.out.println(redisUtil.get("UserInfo"));



    }

    /**
     * 测试从linux中插入数据,是否可以通过RedisTemplate获取数据,如果可以,查看一下linux插入数据,以及RedisTemplate插入数据的区别。
     * 区别:通过redisTemplat写入redis键值和linux写入一样
     */
    public void Text1(){
        redisTemplate.opsForValue().set("value1",1);
        System.out.println(redisTemplate.opsForValue().get("value2"));
    }


    /**
     * 通过redisTemplate给redis插入一个对象和一个集合。
     * 区别:对象一个属性只能存储一个值，集合一个键可以存储多个不同的值
     */
    public void Text2(){
        UserInfo user=new UserInfo();
        user.setId(4);
        user.setName("lmx");
        user.setPwd("123456");
        redisTemplate.opsForValue().set("UserInfo2",user);
         //准备Set集合
         SetOperations<String,String> setOperations=redisTemplate.opsForSet();
         setOperations.add("set","lmx");
         setOperations.add("set","lmj");
         setOperations.add("set","lmq");
         setOperations.add("set","lmp");
         setOperations.add("set","lml");
         Set<String> set=setOperations.members("set");
         redisTemplate.opsForValue().set("UserSet",set);
    }

    /**
     * 通过redisTemplate给redis的对象和集合设置过期时间,检测到期后是否会自动消失
     * 5秒之后，两个键将消失
     */
    @Test
    public void Text3(){
         redisTemplate.expire("UserInfo2", 5000, TimeUnit.MILLISECONDS);
         redisTemplate.expire("UserSet",5000,TimeUnit.MILLISECONDS);
    }

    /**
     *  通过redisUtil给redis插入一个哈希集合,检测和String类型的区别
     *  区别:Hset在redis客户端以表格的方式显示，String的是文本
     */
    @Test
    public void Text4(){
        redisUtil.hset("Hash","name1","lmx");
        redisUtil.hset("Hash","name2","lmj");
        redisUtil.hset("Hash","name3","ljj");
    }

    /**
     * 将一组集合添加到list和set类型中,然后分别打印,检测区别
     * 区别:区别在于list存储如果键值相同会保留下来，Set存储如果键值相同会后值覆盖前值
     */
    @Test
    public void Text5(){
        //准备Map集合
        Map<String,Integer> map=new HashMap<>();
        map.put("Num1",111);
        map.put("Num2",222);
        map.put("Num3",333);
        //将map集合存储到List集合中
        redisUtil.lSet("ListMap",map);
        //将map集合存储到Set集合中
        redisUtil.sSet("SetMap",map);
        //打印结果，
        System.out.println(redisUtil.lGet("ListMap",0,-1));
        System.out.println(redisUtil.sGet("SetMap"));
    }


}
