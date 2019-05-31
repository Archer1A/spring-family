package com.vic.shiro_app.service.impl;

import com.vic.shiro_app.mapper.RoleMapper;
import com.vic.shiro_app.model.SysRole;
import com.vic.shiro_app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author Vic
 * @date 2019/5/30
 */
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<SysRole> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public List<SysRole> getRolesByUserId(int userId) {
        return roleMapper.getRolesByUserId(userId);
    }

    @Override
    public SysRole getRoleById(int id) {
        return roleMapper.getRoleById(id);
    }
}
