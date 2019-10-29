package com.wx.control.controlscheduled.processor;


import com.wx.control.controlscheduled.config.ScheduleConfig;
import com.wx.control.controlscheduled.po.ScheduledConfigPo;
import com.wx.control.controlscheduled.service.ScheduledConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Component
public class InitializeSettings implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(InitializeSettings.class);

    @Autowired
    private ScheduleConfig scheduleConfig;

    @Autowired
    private ScheduledConfigService scheduledConfigService;

    /**
     *  执行定时任务初始化
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            ScheduledConfigPo param = new ScheduledConfigPo();
            param.setState(1);
            List<ScheduledConfigPo> sheduled = scheduledConfigService.findSheduled(param);
            if (!CollectionUtils.isEmpty(sheduled)){
                scheduleConfig.startCron(sheduled);
            }
        }
    }

}