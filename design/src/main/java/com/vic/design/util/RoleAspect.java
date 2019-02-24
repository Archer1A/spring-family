package com.vic.design.util;

import com.vic.design.model.Role;
import org.aspectj.lang.ProceedingJoinPoint;
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
    @Before("execution(* com.vic.design.service.impl..*(..))"+
    "&& args(role,sort)")
    public void before(Role role,int sort) {
        System.out.println("before......." + role.roleName);
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

    @Around("print()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around before......");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after.....");

    }
}
