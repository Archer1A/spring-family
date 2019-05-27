package com.vic.shiro_app;

import com.vic.shiro_app.mapper.PermissionMapper;
import com.vic.shiro_app.model.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ShiroAppApplication  implements ApplicationRunner {

    @Autowired
    PermissionMapper permissionMapper;

    public static void main(String[] args) {
        SpringApplication.run(ShiroAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       List<SysPermission> permissions = permissionMapper.getPermissionsByParentId(1);
       permissions.stream().forEach(System.out::println);
    }
}