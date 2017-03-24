package com.springboot.demo.entity;

import java.io.Serializable;

/**
 * Created by wesley on 2017-03-23.
 * 演示例子
 */
public class Examples implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public Examples() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

}