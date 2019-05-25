package com.vic.shriodemo;

import com.vic.shriodemo.model.SysPermission;
import com.vic.shriodemo.model.SysRole;
import com.vic.shriodemo.model.UserInfo;
import com.vic.shriodemo.service.PermissionService;
import com.vic.shriodemo.service.UserInfoService;
import com.vic.shriodemo.service.impl.PermissionServiceImpl;
import com.vic.shriodemo.service.impl.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
@MapperScan(basePackages = {"com.vic.shriodemo.mapper"})
@Slf4j
public class ShriodemoApplication  implements ApplicationRunner {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    PermissionService permissionService;

    public static void main(String[] args) {
        SpringApplication.run(ShriodemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+getPassword("123456"));

        /*UserInfo user = userInfoService.getUserInfo("zhangsan");

        List<SysRole> roles = userInfoService.getRoleByUserId(user.getUserId());
        Set<String> roleSet = roles.stream().map(SysRole::getRoleName).collect(Collectors.toSet());

        for (SysRole role : user.getRoles()) {
            List<SysPermission> sysPermissions = permissionService.getPermissionByRoleId(role.getRoleId());
            role.setPermissions(new HashSet<>(sysPermissions));
        }
        user.setRoles(new HashSet<>(roles));
        log.info(user.toString());*/

    }

    // 获取加密后的密码
    public String getPassword(String password) {

        String hashAlgorithmName = "md5";
        int  hashIteration = 2;
        ByteSource salt = ByteSource.Util.bytes("2");
        String pwd = new SimpleHash(hashAlgorithmName, password, salt, hashIteration).toString();
        return pwd;

    }
}
