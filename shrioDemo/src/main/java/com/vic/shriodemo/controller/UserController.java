package com.vic.shriodemo.controller;

import com.vic.shriodemo.model.UserInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author Vic
 * @date 2019/5/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/list")
    @RequiresPermissions("systemUserList")
    public String listUser() {
        return "listUser";

    }

    @PostMapping("/addUser")
    @RequiresPermissions("systemUserAdd")
    public String button() {
        return "addUser";
    }

}
