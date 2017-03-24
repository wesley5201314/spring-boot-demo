package com.springboot.demo.service;


import com.springboot.demo.entity.Examples;
import com.springboot.demo.entity.Page;

/**
 * Created by wesley on 2017-03-23.
 * exampleService
 */
public interface ExamplesService {

	/**
	 * add
	 * @param examples
	 * @return
     */
	public boolean add(Examples examples);

	/**
	 * findExamplesById
	 * @param id
	 * @return
     */
	public Examples findExamplesById(String id);

	/**
	 * getAsPage
	 * @param pageIndex
	 * @param pageSize
     * @return
     */
	public Page<Examples> getAsPage(int pageIndex, int pageSize);

	/**
	 * test quartz job
	 * @param s
     */
	public void testQuartzJob(String s);
}
