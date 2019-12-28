package com.wx.control.controlscheduled.scheduled;

import com.wx.control.controlscheduled.config.AbstractTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Test2Scheduled extends AbstractTask {

    private static final Logger logger = LoggerFactory.getLogger(Test2Scheduled.class);

    private Long timestamp = System.currentTimeMillis();

    @Override
    protected void excute() {
        logger.info("---------------测试定时2开始执行-------------------");
        logger.info("2");
        logger.info((System.currentTimeMillis() - timestamp) + "ms");
        timestamp = System.currentTimeMillis();
        logger.info("---------------测试定时2结束执行-------------------");
    }
}
