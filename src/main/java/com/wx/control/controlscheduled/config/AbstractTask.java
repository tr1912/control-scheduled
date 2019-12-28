package com.wx.control.controlscheduled.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(AbstractTask.class);
 
    @Override
    public void run() {
        logger.info("---------------定时开始执行-------------------");
        Long startTime = System.currentTimeMillis();
        excute();
        logger.info("---------------定时执行结束:"+(System.currentTimeMillis() - startTime)+"ms-------------------");
    }

    protected abstract void excute();
}
