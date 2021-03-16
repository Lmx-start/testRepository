package com.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//lombok注解
@Data
@TableName("user_info")
public class UserInfo implements Serializable {
    @TableId(value = "id")
    private int id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "pwd")
    private String pwd;
}
