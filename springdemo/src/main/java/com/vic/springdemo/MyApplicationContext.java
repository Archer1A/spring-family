package com.vic.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * MyApplicationContext
 *
 * @author Vic
 * @date 2019/7/15
 */
@Slf4j
@Component
public class MyApplicationContext implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.info("传入的ioc " + applicationContext);

    }

    @Override
    public void setBeanName(String s) {
        log.info("当前的beanName" +s);
    }


}
