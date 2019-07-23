package com.zyx.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTask {

//    @Scheduled(fixedRate = 2000)
//    @Scheduled(cron = "*/1 * * * * *")
//    @Scheduled(fixedDelay = 2000)
    @Scheduled(fixedDelayString = "${jobs.fixedDelay}")//#定时任务，调用配置文件的方法
    public void sum() throws Exception{

        Thread.sleep(4000);
        System.out.println("当前时间："+new Date());
    }
}
