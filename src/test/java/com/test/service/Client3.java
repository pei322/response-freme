package com.test.service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class Client3 {
    public static void main(String[] args) {
        //注册关系,简化了手动通知观察者的过程
        Observable3.OnAttach3 onAttach = new Observable3.OnAttach3() {
            @Override
            public void call(IObserver3 observer) {
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
                observer.update(list);

            }
        };

        //被观察者
        Observable3 observable = Observable3.create(onAttach);

        //观察者
        IObserver3 observer = new IObserver3<ArrayList<Integer>>() {

            @Override
            public void update(ArrayList<Integer> state) {
                state.stream().forEach(p -> {
                    System.out.println(p);
                });
            }
        };

        //将观察者注册到被观察者上
        observable.attach(observer);
    }
}
