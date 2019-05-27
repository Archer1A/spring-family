package com.vic.shiro_app.service;

import com.vic.shiro_app.model.SysPermission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PermissionService
 *
 * @author Vic
 * @date 2019/5/27
 */
@Service
public interface PermissionService {

    List<SysPermission> getAllPermission();

    List<SysPermission> getPermissionsByParentId(int parentId);
}
