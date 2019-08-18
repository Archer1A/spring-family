package com.vic.springdemo.importPackage;

import org.springframework.context.ApplicationEvent;

/**
 * TestEvent
 * 了解Spring的事件监听
 *
 * @author Vic
 * @date 2019/8/18
 */
public class TestEvent  extends ApplicationEvent {
    public String msg;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }
    public TestEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public void Print() {
        System.out.println(msg);
    }
}
