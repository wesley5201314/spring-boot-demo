package com.springboot.demo.dao;

import java.util.List;

import com.springboot.demo.entity.ScheduleJob;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wesley on 2017-03-23.
 */
public interface ScheduleJobMapper {
	@Select({ "   SELECT                                      "+
			  "        sj.job_id AS jobId,                    "+
			  "        sj.job_name AS jobName,                "+
			  "        sj.job_group AS jobGroup,              "+
			  "        sj.job_status AS JobStatus,            "+
			  "        sj.cron_expression AS cronExpression,  "+
			  "        sj.bean_class AS beanClass,            "+
			  "        sj.create_time AS createTime,          "+
			  "        sj.update_time AS updateTime,          "+
			  "        sj.description AS description          "+
			  "  FROM                                         "+
			  "  schedule_job sj"})
	List<ScheduleJob> getAll();
}
