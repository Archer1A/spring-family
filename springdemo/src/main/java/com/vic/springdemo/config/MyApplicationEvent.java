package com.vic.springdemo.config;

import org.springframework.context.ApplicationEvent;

/**
 * MyApplicationEvent
 *
 * @author Vic
 * @date 2019/7/22
 */
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
