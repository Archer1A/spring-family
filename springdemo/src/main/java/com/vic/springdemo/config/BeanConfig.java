package com.vic.springdemo.config;

import com.vic.springdemo.aop.LogAspect;
import com.vic.springdemo.aop.MathCalculator;
import com.vic.springdemo.importPackage.MyImportBeanDefinitionRegistrar;
import com.vic.springdemo.model.Color;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * BeanConfig
 *
 * @author Vic
 * @date 2019/7/15
 */
@Configuration
//@Import({Color.class,MyImportBeanDefinitionRegistrar.class, LogAspect.class, MathCalculator.class,MyPostProcessor.class})
public class BeanConfig {
}
