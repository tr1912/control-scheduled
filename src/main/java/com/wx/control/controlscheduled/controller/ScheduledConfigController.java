package com.wx.control.controlscheduled.controller;

import com.wx.control.controlscheduled.base.MessageResult;
import com.wx.control.controlscheduled.config.ScheduleConfig;
import com.wx.control.controlscheduled.po.ScheduledConfigPo;
import com.wx.control.controlscheduled.service.ScheduledConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/scheduledConfig")
@Controller
public class ScheduledConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledConfigController.class);

    @Autowired
    private ScheduledConfigService scheduledConfigService;
    @Autowired
    private ScheduleConfig scheduleConfig;

    /**
     * 重新加载定时配置
     *
     * @param state
     * @return
     */
    @RequestMapping("/refreshScheduled")
    @ResponseBody
    public MessageResult refreshScheduled(String state) {

        ScheduledConfigPo param = new ScheduledConfigPo();
        param.setState(1);
        List<ScheduledConfigPo> list = scheduledConfigService.findSheduled(param);
        scheduleConfig.startCron(list);
        return MessageResult.build("1", "成功");
    }
}
