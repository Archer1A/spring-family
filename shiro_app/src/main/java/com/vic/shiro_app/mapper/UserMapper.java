package com.vic.shiro_app.mapper;

import com.vic.shiro_app.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserMapper
 *
 * @author Vic
 * @date 2019/5/27
 */
@Mapper
public interface UserMapper {

    List<SysUser> getAllUsers();

    SysUser getUserByUserName(String userName);

    SysUser getUserByUserId(String userId);
}
