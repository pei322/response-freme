package com.test.service;

/**
 * 客户端测试 代码 2
 */
public class Client2 {
    public static void main(String[] args) {
        /*  第一种调用 方式
         *  在Observable中,我们定义OnAttach接口,
         *  该接口负责通知观察者.
         *  同时attach方法在将观察者注册到被观察者上之后,
         *     会调用OnAttach的call方法来实现自动通知,
         *     这样做的好处就是我们不需要再手动调用call方法来通知被观察者了
         *     —-对用户屏蔽细节.
         */
        Observable observable = new Observable(new Observable.OnAttach() {
            @Override
            public void call(IObserver observer) {
                observer.update("1");
            }
        });

        observable.attach(new IObserver() {
            @Override
            public void update(String state) {
                System.out.println("state:" + state);
            }
        });

        //第二种调用方式
        /* 首先,我们实现OnAttach接口,
        *      该接口含有唯一的方法call.
        *      call方法接受一个Observer对象,
        *      此对象就是我们的观察者对象observer.
        *      当执行observable.attach(observer)方法时,
        *          会引起call方法的调用,
        *          进而执行observer.update(“1”),
        *          然后执行System.out.println(“state:” + state);
        */
        //注册关系,简化了手动通知观察者的过程
        Observable.OnAttach onAttach = new Observable.OnAttach() {
            @Override
            public void call(IObserver observer) {
                observer.update("2");
            }
        };

        //被观察者
        Observable observable2 = new Observable(onAttach);

        //观察者
        IObserver observer = new IObserver() {
            @Override
            public void update(String state) {
                System.out.println("2 state:" + state);
            }
        };

        //将观察者注册到被观察者上
        observable2.attach(observer);

    }
}
