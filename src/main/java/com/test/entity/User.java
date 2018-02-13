package com.test.entity;

import com.test.service.IObserver4;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class User extends Person implements IObserver4<String> {

    private String message;

    public User(int age, String name) {
        super(age, name);
    }

    @Override
    public void update(String state) {
        this.message  = state;
        read();
    }
    public void read(){
        System.out.println(this.getName() + " 收到推送消息： " +this.message );
    }
}
