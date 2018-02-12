package com.test.service;


import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色
 */
public abstract class AbstractSubject {
    private List<IObserver> list = new ArrayList<IObserver>();

    //将observer注册到Subject
    public void attach(IObserver observer) {
        list.add(observer);
    }
    //移除某个observer
    public void detach(IObserver observer) {
        list.remove(observer);
    }
    //通知所有observer 推模型
    public void notifyObservers(String newState) {
        list.stream().forEach(ob->{ob.update(newState);});
    }


}
