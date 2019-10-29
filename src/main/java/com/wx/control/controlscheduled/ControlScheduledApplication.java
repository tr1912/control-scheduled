package com.wx.control.controlscheduled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.wx.control.controlscheduled.dao")
public class ControlScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlScheduledApplication.class, args);
    }

}
