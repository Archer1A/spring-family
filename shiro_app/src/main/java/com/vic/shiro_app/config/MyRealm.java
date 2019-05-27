package com.vic.shiro_app.config;

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
import java.util.HashSet;
import java.util.Set;

/**
 * MyRealm
 *
 * @author Vic
 * @date 2019/5/25
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        Set<String> permission = new HashSet<>(user.getPermissions());
        simpleAuthorizationInfo.setStringPermissions(permission);

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        log.info("UserName=>>>>>>>>>>>" + userName);
        String password =new String ((char[]) authenticationToken.getCredentials());
        log.info("password=>>>>>>>>>>>" + password);
        SysUser user = SysUser.builder().userId(1).userName("zhangsan").password("ebec2a46e3a54b78faf9ca2a3f6378b1").salt("2").build();
        if (null == user) {
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());

        return authenticationInfo;
    }
}