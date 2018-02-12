package com.test.service;

import com.test.IFun;

/**
 * map操作符的具体实现,在这里重点关注一下泛型位置的颠倒
 *
 */
public class OperatorMap<T,R> implements Observable4.Operator<R ,T> {
    private IFun<? super T,? extends R> convert;

    public OperatorMap(IFun<? super T, ? extends R> convert) {
        this.convert = convert;
    }

    @Override
    public IObserver4<? super T> call(IObserver4<? super R> observer) {
        return new IObserver4<T>() {
            @Override
            public void update(T t) {
                observer.update(convert.call(t));

            }
        };
    }
}
