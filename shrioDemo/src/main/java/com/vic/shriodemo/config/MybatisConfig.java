package com.vic.shriodemo.config;

import com.vic.shriodemo.interceptor.SqlStatementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 *
 * @author Vic
 * @date 2019/5/23
 */
@Configuration
public class MybatisConfig {
    @Bean
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }

}
