package com.springboot.demo.dao;

import java.util.List;

import com.springboot.demo.entity.Examples;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/**
 * Created by wesley on 2017-03-23.
 */
public interface ExamplesMapper {
	
	Examples findExamplesById(String id);
	
	@Insert({
        "insert into examples (id, name) ",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}) "
    })
    int insert(Examples record);
	
	@Select({"select * from examples limit #{0},#{1}"})
	List<Examples> getAsPage(int start, int pageSize);
	
	@Select({"select count(1) from examples"})
	int getCount();
}
