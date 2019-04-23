package com.vic.design.service.impl;

import com.vic.design.model.Role;
import com.vic.design.service.RoleService;
import org.springframework.stereotype.Component;

/**
 * RoleServiceAspectImpl
 *
 * @author Vic
 * @date 2019/2/20
 */
@Component
public class RoleServiceAspectImpl implements RoleService {

    @Override
    public void printRole(Role role, int sort) {
        System.out.println(role.toString());
    }
}
