package com.vic.design.service;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String product = (String) arg;
        System.out.println("发布新产品"+product);
    }
}
