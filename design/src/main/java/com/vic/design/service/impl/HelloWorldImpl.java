package com.vic.design.service.impl;

import com.vic.design.service.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello(String msg) {
        System.out.println(msg);
    }
}
