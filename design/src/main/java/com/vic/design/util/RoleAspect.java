package com.vic.design.util;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * RoleAspect
 *
 * @author Vic
 * @date 2019/2/20
 */
@Aspect
@Component
public class RoleAspect {

    @Pointcut("execution(* com.vic.design.service.impl..*.*(..))")
    public void print() {

    }
    @Before("print()")
    public void before() {
        System.out.println("before.......");
    }

    @After("execution(public * com.vic.design.service.*.*.*(..))")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("execution( * com.vic.design.service.impl.RoleServiceAspectImpl.printRole(..))")
    public void afterReturning() {
        System.out.println("afterReturning....");
    }

    @AfterThrowing("execution(* com.vic.design.service.impl.RoleServiceAspectImpl.printRole(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }
}
