package com.vic.springdemo;

import com.vic.springdemo.aop.MathCalculator;
import com.vic.springdemo.config.BeanConfig;
import com.vic.springdemo.importPackage.TestEvent;
import com.vic.springdemo.model.Color;
import com.vic.springdemo.model.Red;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringdemoApplicationTests {
    /**
     *
     *  org.springframework.aop.config.internalAutoProxyCreator
     * 流程：
     *     1. 传入配置类 创建ioc容器
     *     2. 注册配置类，调用refresh() 刷新容器
     *     3. registerBeanPostProcessors(beanFactory) 注册bean 的后置处理器来方便拦截bean的创建
     *          1. beanFactory.getBeanNamesForType 先获取ioc容器中已定义了的需要创建对象的所有beanPostProcessor
     *          2. 添加其他的beanPostProcessor
     *          3. 分离实现了PriorityOrdered的beanPostProcessor
     *          4. 优先注册实现了 PriorityOrdered 的beanPostProcessor
     *          5. 再给容器注册实现了Order接口的beanPostProcessor
     *          6. 注册普通的beanPostProcessor
     *          7. 获取单例bean 如果获取不到 则创建并保存再容器中
     *              1.创建bean实例
     *              2. populateBean: 给bean的各种属性赋值
     *              3. initializationBean ： 初始化bean
     *
     *
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        //Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
       // Color color = (Color) applicationContext.getBean("com.vic.springdemo.config.ColorFactoryBean");
       // Color color2 = (Color) applicationContext.getBean("com.vic.springdemo.config.ColorFactoryBean");
        TestEvent testEvent = new TestEvent("hello", "msg");
        applicationContext.publishEvent(testEvent);
        MathCalculator mathCalculator = (MathCalculator) applicationContext.getBean("mathCalculator");
        mathCalculator.divide(1, 1);
      //  System.out.println("isSingleton ?" + (color ==color2));
     //   System.out.println("color is" + color.getColor());
    }

    @Test
    public void  testComputeIfAbsent() {

        Map<Object, Object> map = new HashMap<>();
        map.put("a", "a");
        Object a = map.computeIfAbsent("a", k -> new Object());
        System.out.println(a);
        System.out.println(map.get("a"));
        Object a1 = map.computeIfPresent("a", (c, d) -> c.toString() + d.toString());
        System.out.println(a1);
        System.out.println(map.toString());

    }

}
