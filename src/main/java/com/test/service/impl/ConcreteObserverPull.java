package com.test.service.impl;

import com.test.service.AbstractSubjectPull;
import com.test.service.IObserverPull;

/**
 * 具体观察者
 */
public class ConcreteObserverPull implements IObserverPull {

    @Override
    public void update(AbstractSubjectPull subject) {
        //根据需求通过subject获取自己所需要的信息
        System.out.println(((ConcreteAbstractSubjectPull) subject).getAuthor());
        System.out.println(((ConcreteAbstractSubjectPull) subject).getTitle());
    }
}
