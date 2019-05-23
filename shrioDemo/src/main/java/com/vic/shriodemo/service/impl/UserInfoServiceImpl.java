package com.vic.shriodemo.service.impl;

import com.vic.shriodemo.mapper.RoleMapper;
import com.vic.shriodemo.mapper.UserMapper;
import com.vic.shriodemo.model.SysRole;
import com.vic.shriodemo.model.UserInfo;
import com.vic.shriodemo.service.UserInfoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserInfoServiceImpl
 *
 * @author Vic
 * @date 2019/5/16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;
    @Override
    public UserInfo getUserInfo(String userName) {
        UserInfo userInfo = userMapper.findUserByUserName(userName);
        return userInfo;
    }

    @Override
    public List<SysRole> getRoleByUserId(int id) {
        return roleMapper.getRoleByUserId(id);
    }
}
