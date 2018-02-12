package com.test.service;

import com.test.service.impl.ConcreteAbstractSubject;
import com.test.service.impl.ConcreteAbstractSubjectPull;
import com.test.service.impl.ConcreteObserverPull;

/**
 * 客户端测试类
 */
public class Client {
    public static void main(String[] args) {
        //推模型 测试
        System.out.println("----- 测试 推模型--------");
        ConcreteAbstractSubject subject = new ConcreteAbstractSubject();
        //将观察者注册到被主题(被观察者)上

        subject.attach(new IObserver() {
            @Override
            public void update(String state) {
                System.out.println("主题状态变化：" + state);
            }
        });

        //Observer observer = new ConcreteObserver();
       // subject.attach(observer);
        subject.change("2");

        //测试 拉模型
        System.out.println("----- 测试 拉模型--------");
        ConcreteAbstractSubjectPull subjectPull = new ConcreteAbstractSubjectPull();
        IObserverPull observerPull = new ConcreteObserverPull();
        subjectPull.attach(observerPull);

        subjectPull.change("java core", "ms");

    }
}
