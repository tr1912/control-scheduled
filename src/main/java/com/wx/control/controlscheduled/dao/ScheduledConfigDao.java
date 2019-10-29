package com.wx.control.controlscheduled.dao;

import com.wx.control.controlscheduled.po.ScheduledConfigPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduledConfigDao {

    /**
     * 按照条件查询定时list
     *
     * @param param
     * @return
     */
    List<ScheduledConfigPo> findSheduled(ScheduledConfigPo param);
}
