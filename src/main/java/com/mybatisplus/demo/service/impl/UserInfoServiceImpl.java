package com.mybatisplus.demo.service.impl;

import com.mybatisplus.demo.entity.UserInfo;
import com.mybatisplus.demo.mapper.UserInfoMapper;
import com.mybatisplus.demo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
