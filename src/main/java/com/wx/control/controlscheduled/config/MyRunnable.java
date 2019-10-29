package com.wx.control.controlscheduled.config;

import java.util.Date;
 
public class MyRunnable implements Runnable {
 
    @Override
    public void run() {
        System.out.print("业务执行了" + new Date());
    }
}
