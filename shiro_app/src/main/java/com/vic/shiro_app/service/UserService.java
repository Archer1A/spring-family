package com.vic.shiro_app.service;

import com.vic.shiro_app.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService
 *
 * @author Vic
 * @date 2019/5/27
 */
@Service
public interface UserService {
    List<SysUser> getAllUsers();

    SysUser getUserByUserName(String userName);

    SysUser getUserByUserId(String userId);

}
