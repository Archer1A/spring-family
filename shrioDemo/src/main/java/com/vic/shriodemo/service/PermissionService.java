package com.vic.shriodemo.service;

import com.vic.shriodemo.model.SysPermission;

import java.util.List;
import java.util.Set;

/**
 * PermissionService
 *
 * @author Vic
 * @date 2019/5/16
 */
public interface PermissionService {

    List<SysPermission> getPermissionByRoleId(int roleId);
}
