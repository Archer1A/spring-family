package com.vic.design.control;

import com.vic.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyModeControl {

    @Autowired
    DynamicProxy dynamicProxy;

    @RequestMapping("/dynamicProxy")
    public String dynamicProxyControl() {
        HelloWorld proxy = (HelloWorld) dynamicProxy.bind(new HelloWorldImpl());
        proxy.sayHello("hello world");
        return "hello world";
    }

    @RequestMapping("/cglibProxy")
    public String CglibProxyControl() {
        BookCglib bookCglib = new BookCglib();
        BookService bookCglibInstance = (BookService) bookCglib.getInstance(new BookService());
        bookCglibInstance.addBook();
        return "Cglib";
    }


    @RequestMapping("/testObserver")
    public String testObserver() {
        ProductList productList  = ProductList.getInstance();
        productList.addObserver(new JingDongObserver());
        productList.addProduct("新产品1");
        return "observer";
    }

}
