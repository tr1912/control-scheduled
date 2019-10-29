package com.wx.control.controlscheduled.service;

import com.wx.control.controlscheduled.po.ScheduledConfigPo;

import java.util.List;

public interface ScheduledConfigService {

    /**
     * 按照条件查询定时任务
     *
     * @param param
     * @return
     */
    List<ScheduledConfigPo> findSheduled(ScheduledConfigPo param);
}
