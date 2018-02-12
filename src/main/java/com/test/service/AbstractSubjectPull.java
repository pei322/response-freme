package com.test.service;


import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色
 */
public abstract class AbstractSubjectPull {
    private List<IObserverPull> list = new ArrayList<IObserverPull>();

    //将observer注册到Subject
    public void attach(IObserverPull observer) {
        list.add(observer);
    }
    //移除某个observer
    public void detach(IObserverPull observer) {
        list.remove(observer);
    }
    //通知所有observer 拉模型
    public void notifyObservers() {

        list.stream().forEach(ob->{ob.update(this);}
        );
    }

    
}
