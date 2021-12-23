package com.ouest.user.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ouest.user.mapper.UserMapper;
import com.ouest.user.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{userId}")
    public User queryByUserId(@PathVariable("userId") Long userId) {
        return userMapper.selectById(userId);
    }
}
