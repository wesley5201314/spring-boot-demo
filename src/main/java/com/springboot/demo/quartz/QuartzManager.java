package com.springboot.demo.quartz;

import com.springboot.demo.entity.ScheduleJob;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by wesley on 2017-03-23.
 * quartzManager
 */
public class QuartzManager {

	public final static Logger log = Logger.getLogger(QuartzManager.class);

	public static void addJob(ScheduleJob job, SchedulerFactoryBean schedulerFactoryBean) throws SchedulerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (!ScheduleJob.JOB_STATUS.equals(job.getJobStatus())) {
			log.error("任务名称 = [" + job.getJobName() + "]---------------状态无效，不启动");
			return;
		}

		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		Class jobClass = Class.forName(job.getBeanClass());
		Object jobObject = jobClass.newInstance();
		if (jobObject == null) {
			log.error("任务名称 = [" + job.getJobName() + "]---------------启动失败");
			return;
		}
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(job.getJobName(), job.getJobGroup()).build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
}
