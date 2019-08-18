package com.vic.springdemo.importPackage;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * TestListener
 *
 * @author Vic
 * @date 2019/8/18
 */
public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            TestEvent testEvent = (TestEvent) event;
            testEvent.Print();
        }


    }
}
