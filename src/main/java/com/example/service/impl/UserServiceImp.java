package com.example.service.impl;

import com.example.entity.dto.User;
import com.example.entity.vo.request.UserVo;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 蓝猫
 * @since 2024-08-03
 */
@Service
public class UserServiceImp extends MPJBaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<UserVo> getUsers() {
        return baseMapper.selectList(null)
                .stream()
                .map(user -> {
                    UserVo userVo = new UserVo();
                    BeanUtils.copyProperties(user, userVo);
                    return userVo;
                })
                .toList();
    }
}
