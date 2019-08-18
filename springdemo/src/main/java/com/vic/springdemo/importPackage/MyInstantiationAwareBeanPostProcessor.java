package com.vic.springdemo.importPackage;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * MyInstantiationAwareBeanPostProcessor
 *
 * @author Vic
 * @date 2019/8/18
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object object, String beanName) {
        System.out.println("===");
        return null;


    }
}
