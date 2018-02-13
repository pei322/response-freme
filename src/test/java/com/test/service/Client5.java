package com.test.service;

import com.test.entity.User;
import com.test.service.impl.WechatServerImpl;

/**
 * Created by jun_pei on 2018/2/12.
 */
public class Client5 {
    public static void main(String[] args) {
            WechatServerImpl server = new WechatServerImpl();

            IObserver4 userZhang = new User(1,"zhang");
            IObserver4 userLi = new User(1,"Li");
            IObserver4 userWang = new User(1,"Wang");

            server.registerObserver(userZhang);
            server.registerObserver(userLi);
            server.registerObserver(userWang);
            server.setInfomation("PHP是世界上最好用的语言！");

            System.out.println("----------------------------------------------");
            server.removeObserver(userZhang);
            server.setInfomation("JAVA是世界上最好用的语言！");
    }
}
