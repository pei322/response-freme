package com.test.service;

import com.test.IFun;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class Client4 {
    public static void main(String[] args) {

        //注册关系,简化了手动通知观察者的过程
        Observable4.OnAttach4 onAttach0 = new Observable4.OnAttach4() {
            @Override
            public void call(IObserver4 observer) {

                observer.update("test");

            }
        };

        //被观察者
        Observable4 observable0 = Observable4.create(onAttach0);

        Observable4 observable1 = observable0.map(new IFun<String, String>() {

            @Override
            public String call(String s) {
                return s + "_map";
            }
        });

        Observable4 observable2 = observable1.map(new IFun<String, String>() {

            @Override
            public String call(String s) {
                return s + "_???";
            }
        });

        //观察者
        IObserver4 observer0 = new IObserver4<String>() {
            @Override
            public void update(String t) {
                System.out.println(t);
            }
        };

        //将观察者注册到被观察者上
        observable2.attach(observer0);

    }
}
