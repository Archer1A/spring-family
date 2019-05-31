package com.vic.shiro_app.config;

import com.vic.shiro_app.mapper.PermissionMapper;
import com.vic.shiro_app.mapper.RoleMapper;
import com.vic.shiro_app.mapper.UserMapper;
import com.vic.shiro_app.model.SysPermission;
import com.vic.shiro_app.model.SysRole;
import com.vic.shiro_app.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MyRealm
 *
 * @author Vic
 * @date 2019/5/25
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysRole> roleList = roleMapper.getRolesByUserId(user.getUserId());
        Set<String> permissionsSet = new HashSet<>();
        for (SysRole sysRole : roleList) {
            List<SysPermission> permissions = permissionMapper.getPermissionByRoleId(sysRole.getRoleId());
            permissionsSet.addAll(permissions.stream().map(SysPermission::getPermission).collect(Collectors.toSet()));
        }

        simpleAuthorizationInfo.setStringPermissions(permissionsSet);

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        log.info("UserName=>>>>>>>>>>>" + userName);
        String password =new String ((char[]) authenticationToken.getCredentials());
        log.info("password=>>>>>>>>>>>" + password);
        SysUser user = userMapper.getUserByUserName(userName);
        if (null == user) {
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());

        return authenticationInfo;
    }
}
