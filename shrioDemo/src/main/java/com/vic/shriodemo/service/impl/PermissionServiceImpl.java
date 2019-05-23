package com.vic.shriodemo.service.impl;

import com.vic.shriodemo.mapper.PermissionMapper;
import com.vic.shriodemo.model.SysPermission;
import com.vic.shriodemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * PermissionServiceImpl
 *
 * @author Vic
 * @date 2019/5/16
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<SysPermission> getPermissionByRoleId(int roleId) {
        return permissionMapper.getPermissionsByRoleId(roleId);
    }
}
