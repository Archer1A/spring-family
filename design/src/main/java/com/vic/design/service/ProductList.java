package com.vic.design.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {

    private List<String> productList = null;

    private static ProductList instance;

    private ProductList(){};

    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    /**
     * 增加观察者
     * @param observer
     */
    public void addProductListObserver(Observer observer) {
        
        this.addObserver(observer);
    }

    public void addProduct(String newProduct) {

        productList.add(newProduct);
        System.out.println("新增产品：" + newProduct);
        this.setChanged(); // 设置被观察对象发生了变化
        this.notifyObservers(newProduct); //通知观察者 并传递新产品
    }
}
