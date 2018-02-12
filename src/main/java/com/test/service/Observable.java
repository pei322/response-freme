package com.test.service;

/**
 * 被观察者
 */
public class Observable {
    protected OnAttach onAttach;

    private Observable() {
    }

    public Observable(OnAttach onAttach) {
        this.onAttach = onAttach;
    }

    public void attach(IObserver observer) {
        onAttach.call(observer);
    }


    public interface OnAttach {
        void call(IObserver observer);
    }
}
