package com.vic.springdemo.config;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * MyApplicationListener
 *
 * @author Vic
 * @date 2019/7/22
 */
//@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println(event.getSource()+"========" + event.getTimestamp());
    }
}
