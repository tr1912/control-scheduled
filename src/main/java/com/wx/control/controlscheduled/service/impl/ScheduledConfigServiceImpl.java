package com.wx.control.controlscheduled.service.impl;

import com.wx.control.controlscheduled.dao.ScheduledConfigDao;
import com.wx.control.controlscheduled.po.ScheduledConfigPo;
import com.wx.control.controlscheduled.service.ScheduledConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledConfigServiceImpl implements ScheduledConfigService {

    @Autowired
    private ScheduledConfigDao scheduledConfigDao;

    @Override
    public List<ScheduledConfigPo> findSheduled(ScheduledConfigPo param) {
        return scheduledConfigDao.findSheduled(param);
    }
}
