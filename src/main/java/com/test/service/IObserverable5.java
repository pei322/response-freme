package com.test.service;

/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 */
public interface  IObserverable5 {

    public  void registerObserver(IObserver4<String> o);
    public void removeObserver(IObserver4<String> o);
    public void notifyObserver();
}
