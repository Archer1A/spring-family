package com.vic.springdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * LogAspect
 *
 * @author Vic
 * @date 2019/7/15
 */
@Slf4j
@Component
@EnableAspectJAutoProxy
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.vic.springdemo.aop.MathCalculator.*(..))")
    private void pointCut() { }
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("除法正在运行...参数列表是{}" , Arrays.asList(args));
    }
    @After("pointCut()")
    public void logEnd() {
        log.info("除法结束...");
    }

    @AfterReturning(value = "pointCut()",returning = "res")
    public void logReturn(Object res) {
        log.info("除法返回...结果列表是{}",res);
    }
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.info("除法异常..." + ex.toString());
    }
}
