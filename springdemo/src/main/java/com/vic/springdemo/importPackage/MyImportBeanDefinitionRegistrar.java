package com.vic.springdemo.importPackage;

import com.vic.springdemo.model.Color;
import com.vic.springdemo.model.Red;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.AnnotationMetadata;
import com.vic.springdemo.model.User;
import org.springframework.stereotype.Component;

/**
 * MyImportBeanDefinitionRegistrar
 *
 * @author Vic
 * @date 2019/7/15
 */
//@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, PriorityOrdered {
    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition  的注册类
     *                 把所有需要的添加到容器的bean，调用registerBeanDefinition 手工注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean  bool =  registry.containsBeanDefinition("user");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Color.class);
        registry.registerBeanDefinition("color",rootBeanDefinition);

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
