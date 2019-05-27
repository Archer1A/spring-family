package com.vic.shiro_app.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole
 *
 * @author Vic
 * @date 2019/5/25
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {
    private int roleId;

    private String roleName;

    private Set<SysPermission> permissions = new HashSet<>();
}
