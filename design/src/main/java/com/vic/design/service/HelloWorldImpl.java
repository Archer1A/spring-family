package com.vic.design.service;

public class HelloWorldImpl  implements HelloWorld{

    @Override
    public void sayHello(String  msg) {
        System.out.println(msg);
    }
}
