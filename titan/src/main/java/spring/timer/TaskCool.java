package spring.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 
 * TaskCool 上午11:40:12
 * 
 * Copyright zhaocj Inc. All rights reserved.
 * Love ME Like Justin Bieber.
 */
@Component
public class TaskCool {
    /**
     * 第一个定时器测试方法  直接配置文件
     */
    public void testJob(){
        System.out.println("test first taskJob not on annotation .... ");
    }
    /**
     * 第二个定时器测试方法  基于注解
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void testJob_two(){
        System.out.println("test second taskJob run on annotation .... ");
    }
}
