package com.vic.shriodemo.mapper;

import com.vic.shriodemo.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * PermissionMapper
 *
 * @author Vic
 * @date 2019/5/16
 */
@Mapper
public interface PermissionMapper {
    @Select("Select  r.* from sys_permission r left join sys_role_permission ur on  ur.role_id = #{roleId} where r.id = ur.permission_id")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "resName",column = "res_name"),
            @Result(property = "resType",column = "res_type"),
            @Result(property = "permission",column = "permission"),
            @Result(property = "permission",column = "permission"),

    })
    List<SysPermission> getPermissionsByRoleId(int roleId);
}
