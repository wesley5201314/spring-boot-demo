package com.springboot.demo.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Created by wesley on 2017-03-23.
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
	 * 
	 */
	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors
				.basePackage("com.springboot.demo.controller"))
				.paths(PathSelectors.any()).build();
	}
	

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("SpringBootDemo", // 大标题
				"Spring boot + swagger + mybatis + druid", // 小标题
				"1.0", // 版本
				"spring-boot-demo",
				"zhengweishan", // 作者
				"blog", // 链接显示文字
				"http://zhengweishan.oschina.io/"// 网站链接
		);
		return apiInfo;
	}
}
