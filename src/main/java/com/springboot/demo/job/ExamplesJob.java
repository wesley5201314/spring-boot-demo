package com.springboot.demo.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.springboot.demo.service.ExamplesService;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wesley on 2017-03-23.
 * ExamplesJob
 */
public class ExamplesJob implements Job {

	private static final Logger logger =Logger.getLogger(ExamplesJob.class);

	@Autowired
	private ExamplesService examplesService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			examplesService.testQuartzJob("Quartz Job "+context.getScheduler().getSchedulerName());
		} catch (SchedulerException e) {
			logger.error("execute service error",e);
		}
		System.out.println("examplesJob:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
