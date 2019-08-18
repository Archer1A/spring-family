package com.vic.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * CustomApplicationContext
 *
 * @author Vic
 * @date 2019/7/15
 */
public class CustomApplicationContext extends AnnotationConfigApplicationContext {

    public CustomApplicationContext(Class<?>... annotatedClasses) {
        super(annotatedClasses);
    }
    @Override
    protected void initPropertySources() {
        //getEnvironment().setRequiredProperties("VAR");
    }

}
