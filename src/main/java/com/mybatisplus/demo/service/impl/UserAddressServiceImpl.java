package com.mybatisplus.demo.service.impl;

import com.mybatisplus.demo.entity.UserAddress;
import com.mybatisplus.demo.mapper.UserAddressMapper;
import com.mybatisplus.demo.service.IUserAddressService;
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
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
