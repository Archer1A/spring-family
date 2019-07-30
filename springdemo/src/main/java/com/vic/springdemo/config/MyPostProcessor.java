package com.vic.springdemo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * MyPostProcessor
 *
 * @author Vic
 * @date 2019/7/16
 */
public class MyPostProcessor implements BeanPostProcessor , PriorityOrdered {

    String color = "color";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (color.equals(beanName)) {
            return bean;
        }
        System.out.println("后置处理器处理Bean=[" + beanName+"] 开始");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (color.equals(beanName)) {
            return bean;
        }
        System.out.println("后置处理器处理Bean=[" + beanName+"] 结束");
        return bean;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
