package com.vic.design.service;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookCglib implements MethodInterceptor {
    private Object target;//业务类对象， 供代理方法中进行真正的业务调用

    public Object getInstance(Object target) {
        this.target = target; //给代理对象赋值
        Enhancer enhancer = new Enhancer(); // 创建加强器，用来创建动态代理
        enhancer.setSuperclass(this.target.getClass());//为加强器制定要代理的业务（即：为下面生成的代理类指定父类）
        //设置回调 对于代理类上的所有方法的调用，都会调用callBack,而CallBack则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        //创建代理对象并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("预处理....");
        methodProxy.invokeSuper(o, objects);
        System.out.println("调用后....");
        return null;
    }
}
