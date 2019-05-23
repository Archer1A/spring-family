package com.vic.shriodemo.service;

import com.vic.shriodemo.model.SysRole;
import com.vic.shriodemo.model.UserInfo;

import java.util.List;

/**
 * UserInfoService
 *
 * @author Vic
 * @date 2019/5/12
 */
public interface UserInfoService {

    UserInfo getUserInfo(String userName);

    List<SysRole> getRoleByUserId(int id);
}
