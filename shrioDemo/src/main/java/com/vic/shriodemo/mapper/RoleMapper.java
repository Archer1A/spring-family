package com.vic.shriodemo.mapper;

import com.vic.shriodemo.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * RoleMapper
 *
 * @author Vic
 * @date 2019/5/16
 */
@Mapper
public interface RoleMapper {

    @Select("Select  r.* from sys_role r " +
            "left join sys_user_role ur on  ur.user_id = #{id} " +
            "where r.role_id = ur.role_id ")
    @Results({
            @Result(property = "roleId",column = "role_Id"),
            @Result(property = "roleName",column = "role_name")
    })
    List<SysRole> getRoleByUserId(int id);
}
