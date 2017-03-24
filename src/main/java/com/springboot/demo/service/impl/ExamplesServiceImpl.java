package com.springboot.demo.service.impl;

import java.util.List;

import com.springboot.demo.dao.ExamplesMapper;
import com.springboot.demo.entity.Examples;
import com.springboot.demo.entity.Page;
import com.springboot.demo.service.ExamplesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wesley on 2017-03-23.
 * exampleServiceImpl
 */
@Service
public class ExamplesServiceImpl implements ExamplesService {

	private static final Logger logger = Logger.getLogger(ExamplesServiceImpl.class);

	@Autowired
	private ExamplesMapper mapper;

	@Override
	public boolean add(Examples examples) {
		logger.info("<-- service add start -->");
		return mapper.insert(examples) > 0;
	}

	@Override
	public Examples findExamplesById(String id) {
		return mapper.findExamplesById(id);
	}

	@Override
	public Page<Examples> getAsPage(int pageIndex, int pageSize) {
		Page<Examples> page = new Page<Examples>();
		int start = (pageIndex - 1) * pageSize;
		List <Examples> data = mapper.getAsPage(start, pageSize);
		page.setData(data);
		int totalCount = mapper.getCount();
		page.setTotalCount(totalCount);
		int totalPageNum = (totalCount + (pageSize-1))/pageSize;
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalPageNum(totalPageNum);
		return page;
	}

	@Override
	public void testQuartzJob(String s) {
		System.out.println("Quartz Job service ["+s+"] start!!");
	}

}
