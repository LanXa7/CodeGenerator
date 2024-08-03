package com.example.mapper;

import com.example.entity.dto.User;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 蓝猫
 * @since 2024-08-03
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<User> {

}
