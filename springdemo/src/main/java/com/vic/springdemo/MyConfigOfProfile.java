package com.vic.springdemo;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * MyConfigOfProfile
 *
 *  profile :
 *   Spring 为我们提供的可以根据当前环境，动态的激活和切换一系列的功能
 *
 *   开发环境，测试环境，生产环境
 *   数据源~
 * @author Vic
 * @date 2019/7/15
 */
@Profile("test")
//@Import("")
public class MyConfigOfProfile {
}
