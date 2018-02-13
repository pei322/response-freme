package com.test.service.impl;

import com.test.service.IObserver4;
import com.test.service.IObserverable5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class WechatServerImpl implements IObserverable5 {

    private List<IObserver4<String>> list;
    private String message;


    public WechatServerImpl() {
        list = new ArrayList<IObserver4<String>>();
    }

    @Override
    public void registerObserver(IObserver4<String> o) {
        list.add(o);
    }

    @Override
    public void removeObserver(IObserver4<String> o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            IObserver4<String> oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("服务器更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
