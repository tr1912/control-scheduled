package com.wx.control.controlscheduled.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1Scheduled implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Test1Scheduled.class);

    private Long timestamp = System.currentTimeMillis();

    private String s;

    @Override
    public void run() {
        logger.info("---------------测试定时1开始执行-------------------");
        logger.info("1");
        logger.info((System.currentTimeMillis() - timestamp) + "ms");
        timestamp = System.currentTimeMillis();
        logger.info("---------------测试定时1结束执行-------------------");
    }
}
