package com.vic.shriodemo.model;

import lombok.*;

/**
 * SysPermission
 *
 * @author Vic
 * @date 2019/5/12
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;

    private int parentId;

    private String resName;

    private String resType;

    private String permission;

    private String url;


}
