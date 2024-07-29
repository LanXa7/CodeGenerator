package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蓝猫
 * @since 2024-07-29
 */
@Service
public class UserServiceImp extends MPJBaseServiceImpl<UserMapper, User> implements UserService {

}
