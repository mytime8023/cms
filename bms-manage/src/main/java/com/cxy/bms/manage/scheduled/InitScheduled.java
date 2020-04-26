package com.cxy.bms.manage.scheduled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenxy
 * @date 2020/4/26 16:02
 * @desc this is description
 */
@Component
@EnableScheduling
public class InitScheduled {

    @Value("${budget-auto-init-cron}")
    private String budgetAutoInitTime;


    @Scheduled(cron = "${budget-auto-init-cron}")
    public void budgetAutoInitTime(){
        System.out.println("执行定时任务：budgetAutoInitTime:[{" + budgetAutoInitTime + "}]");
    }

}
