package com.vic.shiro_app.mapper;

import com.vic.shiro_app.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * PermissionMapper
 *
 * @author Vic
 * @date 2019/5/27
 */
@Mapper
public interface PermissionMapper {

    List<SysPermission> getAllPermissions();

    List<SysPermission> getPermissionsByParentId(int parentId);

}
