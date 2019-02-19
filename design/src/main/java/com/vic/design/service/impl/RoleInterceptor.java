package com.vic.design.service.impl;

import com.vic.design.service.Interceptor;

/**
 * RoleInterceptor
 *
 * @author Vic
 * @date 2019/2/19
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object obj) {

        System.out.println("打印结束");

    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("打印完成");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("打印异常");
    }
}
