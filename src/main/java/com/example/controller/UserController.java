package com.example.controller;

import com.example.entity.dto.User;
import com.example.entity.vo.request.UserVo;
import com.example.entity.vo.response.Result;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 蓝猫
 * @since 2024-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping
    public Result<List<UserVo>> getUser() {
        return Result.success(userService.getUsers());
    }


    @PutMapping
    public Result<Void> updateUser(@Valid @RequestBody UserVo vo) {
        User user = new User();
        BeanUtils.copyProperties(vo, user);
        System.out.println(user);
        if (userService.updateById(user)) {
            return Result.success();
        }
        return Result.failure(400, "更新失败");
    }

    @PostMapping
    public Result<Void> insertUser(@Valid @RequestBody UserVo vo) {
        User user = new User();
        BeanUtils.copyProperties(vo, user);
        userService.save(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Long id) {
        userService.removeById(id);
        return Result.success();
    }
}
