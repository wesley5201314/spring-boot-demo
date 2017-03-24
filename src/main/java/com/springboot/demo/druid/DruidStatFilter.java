package com.springboot.demo.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

import java.io.Serializable;

/**
 * Created by wesley on 2017-03-23.
 * druidWebStatFilter
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
      }
)
public class DruidStatFilter extends WebStatFilter implements Serializable{
     private static final long serialVersionUID = 1L;
}

