package com.vic.shiro_app.service.impl;

import com.vic.shiro_app.mapper.PermissionMapper;
import com.vic.shiro_app.model.SysPermission;
import com.vic.shiro_app.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * PermissionServiceImpl
 *
 * @author Vic
 * @date 2019/5/27
 */
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<SysPermission> getAllPermission() {
        return permissionMapper.getAllPermissions();
    }

    @Override
    public List<SysPermission> getPermissionsByParentId(int parentId) {
        return permissionMapper.getPermissionsByParentId(parentId);
    }

    @Override
    public List<SysPermission> getPermissionByRoleId(int roleId) {
        return permissionMapper.getPermissionByRoleId(roleId);
    }
}
