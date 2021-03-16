package com.mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    //自定义Sql语句
    @Insert("insert into user_info(name,pwd) values(#{name},#{pwd});")
    Integer addUser(String name,String pwd);
}
