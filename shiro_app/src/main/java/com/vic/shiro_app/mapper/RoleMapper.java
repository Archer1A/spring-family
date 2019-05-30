package com.vic.shiro_app.mapper;

import com.vic.shiro_app.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * RoleMapper
 *
 * @author Vic
 * @date 2019/5/27
 */
@Mapper
public interface RoleMapper {

    List<SysRole> getAllRoles();

    List<SysRole> getRolesByUserId(int userId);

    SysRole getRoleById( int id);
}
