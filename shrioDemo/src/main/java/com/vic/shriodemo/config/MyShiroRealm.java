package com.vic.shriodemo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;
import com.vic.shriodemo.model.SysPermission;
import com.vic.shriodemo.model.SysRole;
import com.vic.shriodemo.model.UserInfo;
import com.vic.shriodemo.service.PermissionService;
import com.vic.shriodemo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * MyShiroRealm
 *
 * @author Vic
 * @date 2019/5/12
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权开始 >>>>>>>>>>");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        Set<String> roles =  userInfo.getRoles().stream().map(SysRole::getRoleName).collect(Collectors.toSet());
        List<SysPermission> permissions = new ArrayList<>();
        simpleAuthorizationInfo.setRoles(roles);
        for (SysRole role : userInfo.getRoles()) {
            List<SysPermission> permissionList = permissionService.getPermissionByRoleId(role.getRoleId());
            permissions.addAll(permissionList);
        }
        Set<String> permissionNames = permissions.stream().map(SysPermission::getPermission).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
        log.info("授权 >>>>>>>>>>"+permissionNames.toString());
      //  Set<SysPermission> permissions = new HashSet<>();
        return simpleAuthorizationInfo;
    }

    /**
     * 验证当前登录的subject
     * 调用login时执行
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        log.info("userName >>>>> "  + userName);
        String password = new String( (char[])authenticationToken.getCredentials());
        log.info("password >>>>> "  + password);
        UserInfo userInfo = userInfoService.getUserInfo(userName);
        if (null == userInfo){
            throw new UnknownAccountException();
        }
        List<SysRole> roles = userInfoService.getRoleByUserId(userInfo.getUserId());
        userInfo.setRoles(new HashSet<>(roles));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
       // userInfo.setPassword(null);
       // SecurityUtils.getSubject().getSession().setAttribute("userInfo", JSON.toJSONString(userInfo));
        return authenticationInfo;
    }
}
