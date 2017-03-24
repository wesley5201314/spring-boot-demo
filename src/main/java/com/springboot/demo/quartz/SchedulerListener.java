package com.springboot.demo.quartz;

import com.springboot.demo.dao.ScheduleJobMapper;
import com.springboot.demo.entity.ScheduleJob;
import org.apache.log4j.Logger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.List;

/**
 * Created by wesley on 2017-03-23.
 * quartz job Listener
 */
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(SchedulerListener.class);
	
	@Autowired
	private ScheduleJobMapper scheduleJobMapper;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("ScheduleJobMapper ---->:"+scheduleJobMapper.toString());
        try { 
        	// 这里从数据库中获取任务信息数据
            List<ScheduleJob> jobList = scheduleJobMapper.getAll();
            for (ScheduleJob job : jobList) {  
            	QuartzManager.addJob(job,schedulerFactoryBean);  
            } 
            
        } catch (Exception e) { 
           logger.error("get job list error",e);
        }
     }
    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        return schedulerFactoryBean; 
    }

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext){
        QuartzJobFactory quartzJobFactory = new QuartzJobFactory();
        quartzJobFactory.setApplicationContext(applicationContext);
        return quartzJobFactory;
    }

}
