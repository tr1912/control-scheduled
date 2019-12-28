package com.wx.control.controlscheduled.scheduled;

import com.wx.control.controlscheduled.config.AbstractTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Test1Scheduled extends AbstractTask {

    private static final Logger logger = LoggerFactory.getLogger(Test1Scheduled.class);

    private Long timestamp = System.currentTimeMillis();

    @Override
    protected void excute() {
        logger.info("---------------测试定时1开始执行-------------------");
        logger.info("1");
        logger.info((System.currentTimeMillis() - timestamp) + "ms");
        timestamp = System.currentTimeMillis();
        logger.info("---------------测试定时1结束执行-------------------");
    }
}
