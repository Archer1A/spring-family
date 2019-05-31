package com.vic.shiro_app.service.impl;

import com.vic.shiro_app.mapper.UserMapper;
import com.vic.shiro_app.model.SysUser;
import com.vic.shiro_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author Vic
 * @date 2019/5/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<SysUser> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public SysUser getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public SysUser getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }
}
