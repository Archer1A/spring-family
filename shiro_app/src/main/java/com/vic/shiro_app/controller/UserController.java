package com.vic.shiro_app.controller;

import com.vic.shiro_app.model.SysUser;
import com.vic.shiro_app.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author Vic
 * @date 2019/5/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/listAll")
    @RequiresPermissions("systemUserList")
    public List<SysUser> getAllUsers() {
        return userService.getAllUsers();
    }

}
