package com.zyx.util.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        System.out.println("================requestDestroyed================");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("================requestInitialized==============");

    }
}
