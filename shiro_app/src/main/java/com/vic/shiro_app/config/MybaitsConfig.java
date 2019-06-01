package com.vic.shiro_app.config;

import com.vic.shiro_app.interceptor.SqlStatementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybaitsConfig
 *
 * @author Vic
 * @date 2019/5/31
 */
@Configuration
public class MybaitsConfig {
    @Bean
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }
}
