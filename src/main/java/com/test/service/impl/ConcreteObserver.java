package com.test.service.impl;

import com.test.service.IObserver;

/**
 * 具体观察者
 */
public class ConcreteObserver implements IObserver {

    @Override
    public void update(String state) {
        System.out.println("主题状态改变了：" + state);
    }
}
