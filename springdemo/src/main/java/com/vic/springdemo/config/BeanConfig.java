package com.vic.springdemo.config;

import com.vic.springdemo.aop.LogAspect;
import com.vic.springdemo.aop.MathCalculator;
import com.vic.springdemo.importPackage.MyInstantiationAwareBeanPostProcessor;
import com.vic.springdemo.importPackage.TestListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * BeanConfig
 *
 * @author Vic
 * @date 2019/7/15
 */
@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {
    @Bean("logAspect")
    public LogAspect getLogAspect() {
        LogAspect logAspect = new LogAspect();
        return logAspect;
    }
    @Bean("mathCalculator")
    public MathCalculator getMathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor getMyInstrantiationAwareBeanPostProcessor() {
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public TestListener getTestListener() {
        return new TestListener();
    }
}
