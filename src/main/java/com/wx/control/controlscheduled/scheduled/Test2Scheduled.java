package com.wx.control.controlscheduled.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2Scheduled implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Test2Scheduled.class);

    private Long timestamp = System.currentTimeMillis();

    private String s;

    @Override
    public void run() {
        logger.info("---------------测试定时2开始执行-------------------");
        logger.info("2");
        logger.info((System.currentTimeMillis() - timestamp) + "ms");
        timestamp = System.currentTimeMillis();
        logger.info("---------------测试定时2结束执行-------------------");
    }
}
