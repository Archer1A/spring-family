package com.vic.shiro_app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String index() {
        return "index";
    }

    @PostMapping("auth")
    public String login(){
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception ex) {
            return "fail";
        }


        return "success";
    }


}
