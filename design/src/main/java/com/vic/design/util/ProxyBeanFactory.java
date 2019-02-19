package com.vic.design.util;

import com.vic.design.service.Interceptor;

public class ProxyBeanFactory {

    public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj,interceptor);

    }

}
