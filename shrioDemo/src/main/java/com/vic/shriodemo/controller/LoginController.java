package com.vic.shriodemo.controller;

import com.vic.shriodemo.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 *
 * @author Vic
 * @date 2019/5/23
 */
@RestController
public class LoginController {

    @PostMapping("/auth")
    public String authLogin(@RequestBody UserInfo userInfo) {
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), userInfo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception ex) {
            return "Error";
        }
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        return "Success";
    }

    @GetMapping("/login")
    public String login() {
        return "login page";
    }


}
