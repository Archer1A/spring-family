package com.vic.design.control;

import com.vic.design.model.Role;
import com.vic.design.service.*;
import com.vic.design.service.impl.*;
import com.vic.design.util.ProxyBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyModeControl {

    @Autowired
    DynamicProxy dynamicProxy;

    @Autowired
    RoleService roleService;

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

    @RequestMapping("/role")
    public String getRoleService() {
        int temp1 = 50;
        int temp2 = 100;
        int temp3 = temp1 +temp2;
//        RoleService proxy = ProxyBeanFactory.getBean(new RoleServiceImpl(), new RoleInterceptor());
        Role role = new Role();
        role.roleName = "经理";
//        proxy.printRole(role);
//        System.out.println("-----------------------------");
//        role = null;
//        proxy.printRole(role);

        roleService.printRole(role,1);
        return "Role";
    }

}
