package com.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by wesley on 2017-03-23.
 */
@SpringBootApplication
@ServletComponentScan    //扫描Servlet
@MapperScan("com.springboot.demo.dao") //扫描dao
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
