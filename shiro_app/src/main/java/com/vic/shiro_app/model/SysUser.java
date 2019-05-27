package com.vic.shiro_app.model;

import lombok.*;

import java.security.Permission;
import java.util.List;

/**
 * SysUser
 *
 * @author Vic
 * @date 2019/5/25
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUser {

    private int userId;

    private String userName;

    private String fullName;

    private String password;

    private String salt;

    private List<String> permissions;
}
