package com.vic.design.service;

/**
 * 拦截接口
 */
public interface Interceptor {

    void before(Object obj);

    void after(Object obj);

    void afterReturning(Object obj);

    void afterThrowing(Object obj);
}
