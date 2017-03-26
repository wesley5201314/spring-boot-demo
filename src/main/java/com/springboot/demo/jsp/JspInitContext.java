package com.springboot.demo.jsp;

import com.springboot.demo.App;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by wesley on 2017-03-25.
 * spring boot jsp支持
 */
public class JspInitContext extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}
