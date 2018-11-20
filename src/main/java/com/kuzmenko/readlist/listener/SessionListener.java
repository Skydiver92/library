package com.kuzmenko.readlist.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent){
        System.out.println("======= ЗАШЁЛ ПОЛЬЗОВАТЕЛЬ");
        //httpSessionEvent.getSession().setAttribute("CONNECT", Factory.getConnection());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //Factory factory = new Factory();
        //factory.closeConnection();
        System.out.println("======= УШЁЛ ПОЛЬЗОВАТЕЛЬ");
    }
}
