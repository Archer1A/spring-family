package com.vic.shiro_app.controller;

import com.vic.shiro_app.annotation.LoggingAnnotation;
import com.vic.shiro_app.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 *
 * @author Vic
 * @date 2019/5/25
 */
@RestController
public class LoginController {

    @GetMapping("/index")
    @LoggingAnnotation()
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "this is login page";
    }

    @PostMapping("auth")
    @LoggingAnnotation()
    public String login(@RequestBody SysUser sysUser){
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(), sysUser.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception ex) {
            return "fail";
        }
        return "success";
    }


}
