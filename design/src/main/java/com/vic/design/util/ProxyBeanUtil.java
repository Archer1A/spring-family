package com.vic.design.util;

import com.vic.design.service.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class ProxyBeanUtil implements InvocationHandler {

    //被代理的对象
    private Object obj;

    //拦截器
    private Interceptor interceptor = null;

    public static Object getBean(Object obj, Interceptor interceptor) {
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.obj = obj;
        _this.interceptor = interceptor;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),_this);


    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        boolean exceptionFlag = false;
        interceptor.before(obj);
        try {
            ret = method.invoke(obj, args);
        } catch (Exception ex) {
            exceptionFlag = true;
        }finally {
            interceptor.after(obj);
        }
        if (exceptionFlag) {
            interceptor.afterThrowing(obj);
        } else {
            interceptor.afterReturning(obj);

        }
        return ret;
    }
}
