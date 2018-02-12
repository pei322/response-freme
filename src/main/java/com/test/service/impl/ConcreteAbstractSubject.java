package com.test.service.impl;

import com.test.service.AbstractSubject;

/**
 * 具体主题角色
 */
public class ConcreteAbstractSubject extends AbstractSubject {
    public void change(String state) {
        this.notifyObservers(state);
    }
}
