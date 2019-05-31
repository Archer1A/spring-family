package com.vic.shiro_app.service;

import com.vic.shiro_app.model.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RoleService
 *
 * @author Vic
 * @date 2019/5/30
 */
@Service
public interface RoleService {

    List<SysRole> getAllRoles();

    List<SysRole> getRolesByUserId(int userId);

    SysRole getRoleById( int id);

}
