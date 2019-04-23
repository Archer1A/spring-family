package com.vic.design.service.impl;

import com.vic.design.model.Role;
import com.vic.design.service.RoleService;

/**
 * RoleServiceImpl
 *
 * @author Vic
 * @date 2019/2/19
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role, int sort) {
        System.out.println(role.toString());
    }
}
