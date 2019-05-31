package com.vic.shiro_app.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vic.shiro_app.annotation.LoggingAnnotation;
import com.vic.shiro_app.model.SysUser;
import com.vic.shiro_app.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listAll")
    @RequiresPermissions("systemUserList")
    @LoggingAnnotation
    public PageInfo<SysUser> getAllUsers(@RequestParam int pageNum,@RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(userService.getAllUsers());
        return sysUserPageInfo;
    }

}
