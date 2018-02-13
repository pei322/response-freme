package com.test.service;

import com.test.entity.User;
import com.test.service.impl.WechatServerImpl;

/**
 * 观察者框测试
 */
public class Client5 {
    public static void main(String[] args) {
            //服务
            WechatServerImpl server = new WechatServerImpl();

            //创建用户
            IObserver4 userZhang = new User(1,"zhang");
            IObserver4 userLi = new User(1,"Li");
            IObserver4 userWang = new User(1,"Wang");

            //注册用户
            server.registerObserver(userZhang);
            server.registerObserver(userLi);
            server.registerObserver(userWang);
            //服务器发布消息
            server.setInfomation("PHP是世界上最好用的语言！");

            System.out.println("----------------------------------------------");
            //删除订阅用户
            server.removeObserver(userZhang);
            //服务器重新发布新消息
            server.setInfomation("JAVA是世界上最好用的语言！");
    }
}
