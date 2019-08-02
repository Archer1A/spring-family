package com.vic.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * BeanConfig
 *
 * @author Vic
 * @date 2019/7/15
 */
@Configuration
@Import(ColorFactoryBean.class)
public class BeanConfig {
}
