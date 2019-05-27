package com.vic.shiro_app.model;

import lombok.*;

/**
 * SysPermission
 *
 * @author Vic
 * @date 2019/5/25
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;

    private Integer parentId;

    private String resName;

    private String resType;

    private String permission;

    private String url;
}
