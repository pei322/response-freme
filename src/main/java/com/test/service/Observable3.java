package com.test.service;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class Observable3<T> {
    protected OnAttach3 onAttach3;

    public Observable3(OnAttach3 onAttach3) {
        this.onAttach3 = onAttach3;
    }

    public static <T> Observable3<T> create(OnAttach3<T> onAttach3) {
        return new Observable3(onAttach3);
    }


    public void attach(IObserver3<T> observer) {
        onAttach3.call(observer);
    }

    public interface OnAttach3<T> {
        void call(IObserver3<? super T> observer);
    }
}
