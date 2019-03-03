package com.vic.springdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * user
 *
 * @author Vic
 * @date 2019/3/3
 */
@Getter
@Setter
@Builder
@ToString
public class User {
    private long id;

    private String name;

    private String phone;
}
