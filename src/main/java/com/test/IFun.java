package com.test;

/**
 * Created by jun_pei on 2018/2/12.
 */
public interface IFun<T, R> {
    R call(T t);
}
