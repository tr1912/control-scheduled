package com.wx.control.controlscheduled.po;

import lombok.Data;

@Data
public class ScheduledConfigPo {

    private Integer id;

    private String classReference;

    private String cron;

    private String classParam;

    private String remark;

    private Integer state;

    private Integer sysNumber;

    private String flag1;
}
