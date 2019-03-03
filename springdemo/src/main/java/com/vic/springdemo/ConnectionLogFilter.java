package com.vic.springdemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * ConnectionLogFilter
 *
 * @author Vic
 * @date 2019/3/3
 */
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("BEFORE CONNECTION !");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("AFTER CONNECTION !");
    }

}
