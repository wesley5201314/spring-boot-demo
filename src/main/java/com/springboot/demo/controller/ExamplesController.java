package com.springboot.demo.controller;

import com.springboot.demo.dao.ExamplesMapper;
import com.springboot.demo.entity.Examples;
import com.springboot.demo.entity.Page;
import com.springboot.demo.service.ExamplesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wesley on 2017-03-23.
 * ExamplesController
 */
@Api(value = "示例接口")
@RestController
@RequestMapping("/examples")
@EnableAutoConfiguration
public class ExamplesController {
	
	private Logger log = Logger.getLogger(ExamplesController.class);
	
	@Autowired
	private ExamplesService examplesService;
	
	@Autowired
	private ExamplesMapper mapper;

	/**
	 * add
	 * @param examples
	 * @return
     */
	@RequestMapping("/add")
	@ApiOperation(notes = "添加示例", value = "添加示例", httpMethod = "POST")
	@ApiImplicitParam(name = "examples", value = "示例实体", required = true, dataType = "Examples")
	public String add(@RequestBody Examples examples) {
		log.info("add example start!!");
		return "result:" + examplesService.add(examples);
	}

	/**
	 * select1
	 * @param id
	 * @return
     */
	@RequestMapping("/select1")
	@ApiOperation(notes = "查询示例(三层结构)", value = "查询示例(三层结构)", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "id", required = true, paramType = "query", dataType = "String")
	public Examples select1(@RequestParam String id) {
		log.info("select1:@--@1");
		return examplesService.findExamplesById(id);
	}

	/**
	 * select2
	 * @param id
	 * @return
     */
	@RequestMapping("/select2")
	@ApiOperation(notes = "查询示例(两层结构)", value = "查询示例(两层结构)", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "id", required = true, paramType = "query", dataType = "String")
	public Examples select2(@RequestParam String id) {
		log.info("select2:@--@2");
		return mapper.findExamplesById(id);
	}

	/**
	 * select3
	 * @param pageIndex
	 * @param pageSize
     * @return
     */
	@RequestMapping("/select3")
	@ApiOperation(notes = "查询示例(分页)", value = "查询示例(分页)", httpMethod = "POST")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageIndex", value = "当前页",
                    required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数",
                    required = true, paramType = "query", dataType = "Integer")
    })
	public Page<Examples> select3(@RequestParam Integer pageIndex, Integer pageSize) {
		log.info("select3:@--@3");
		return examplesService.getAsPage(pageIndex, pageSize);
	}
}
