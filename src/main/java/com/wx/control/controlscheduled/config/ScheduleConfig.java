package com.wx.control.controlscheduled.config;

import com.wx.control.controlscheduled.po.ScheduledConfigPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
 
 
@Configuration
public class ScheduleConfig {
 
    private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);
 
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
 
 
    /**
     * 存放所有启动定时任务对象，极其重要
     */
    private HashMap<String, ScheduledFuture<?>> scheduleMap = new HashMap<>();
 
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
 
 
    /**
     * @param crons
     * 动态设置定时任务方法
     * 
     * 此方法是真正的动态实现启停和时间周期的关键，你可以针对自己的业务来调用，你对库中的动态数据修改后来调用此方法，每个Cron对象必须要包含，执行周期（cron.getCron()），启停状态（cron.getCronStatus()），执行的类（cron.getCronClass()）
     */
    public void startCron(List<ScheduledConfigPo> crons){
        try {
            //遍历所有库中动态数据，根据库中class取出所属的定时任务对象进行关闭，每次都会把之前所有的定时任务都关闭，根据新的状态重新启用一次，达到最新配置
            for (ScheduledConfigPo cron : crons){
                ScheduledFuture<?> scheduledFuture = scheduleMap.get(cron.getClassReference());
                //一定判空否则出现空指针异常，ToolUtil为自己写的工具类此处只需要判断对象是否为空即可
                if (scheduledFuture!=null && scheduledFuture.isDone()){
                    scheduledFuture.cancel(true);
                }
            }
            //因为下边存储的是新的定时任务对象，以前的定时任务对象已经都停用了，所以旧的数据没用清除掉，这步可以不处理，因为可以是不可重复要被覆盖
            //scheduleMap.clear();
            //遍历库中数据，之前已经把之前所有的定时任务都停用了，现在判断库中如果是启用的重新启用并读取新的数据，把开启的数据对象保存到定时任务对象中以便下次停用
            for (ScheduledConfigPo cron : crons){
                //判断当前定时任务是否有效，COMMON_API_WRAPPER_STATIC_VALUE.VALIDFLAG.TRUE为有效标识
                if (cron.getState().equals(1)) {
                    //开启一个新的任务，库中存储的是全类名（包名加类名）通过反射成java类，读取新的时间
                    ScheduledFuture<?> future = threadPoolTaskScheduler.schedule((Runnable) Class.forName(cron.getClassReference()).newInstance(), new CronTrigger(cron.getCron()));
                    //这一步非常重要，之前直接停用，只停用掉了最后启动的定时任务，前边启用的都没办法停止，所以把每次的对象存到map中可以根据key停用自己想要停用的
                    scheduleMap.put(cron.getClassReference(),future);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}