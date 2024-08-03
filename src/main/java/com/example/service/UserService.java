package com.example.service;

import com.example.entity.dto.User;
import com.example.entity.vo.request.UserVo;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 蓝猫
 * @since 2024-08-03
 */
public interface UserService extends MPJBaseService<User> {

    List<UserVo> getUsers();
}
