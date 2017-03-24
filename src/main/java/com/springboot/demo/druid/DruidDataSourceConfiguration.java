package com.springboot.demo.druid;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wesley on 2017-03-23.
 * DruidDataSourceConfiguration
 */
@Configuration
public class DruidDataSourceConfiguration {
	private static final Logger logger = Logger.getLogger(DruidDataSourceConfiguration.class);

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		DataSource druidDataSource = new DruidDataSource();
		logger.info("druidDataSource:"+druidDataSource.toString());
		return druidDataSource;
	}
}
