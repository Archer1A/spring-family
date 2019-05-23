package com.vic.shriodemo.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo
 *
 * @author Vic
 * @date 2019/5/12
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private int userId;

    private String userName;

    private String fullName;

    private String password;

    private int salt;

    private Set<SysRole> roles = new HashSet<>();

}
