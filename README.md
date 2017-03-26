# spring-boot-demo #

spring boot + mybatis + quartz + druid + Swagger2 演示demo

说明：主要演示如何整合，简单的任务调用。

环境准备：

- jdk:1.7
- maven:3.2.3
- 开发工具：IDEA

源码地址：

gitosc: [https://git.oschina.net/zhengweishan/spring-boot_demo](https://git.oschina.net/zhengweishan/spring-boot_demo)

github: [https://github.com/wesley5201314/spring-boot-demo](https://github.com/wesley5201314/spring-boot-demo)

项目结构：

![](http://i.imgur.com/LNzimT3.png)

**备注：**
每个包的作用大家一看就明白了，这里主要说明下application.properties：这里主要配置针对于不同的环境用那个配置文件，这里我只提供了开发，测试的环境属性文件。配置如下：

	spring.profiles.active = dev

应用启动：

	//启动入口
	@SpringBootApplication
	@ServletComponentScan    //扫描Servlet
	@MapperScan("com.springboot.demo.dao") //扫描dao
	public class App 
	{
	    public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	    }
	}

启动之后访问：
durid ： http://localhost:8080/druid/index.html 如图：

![](http://i.imgur.com/qD8hyb4.png)

登录之后：

![](http://i.imgur.com/Eb4k89i.png)

配置代码：
	
	//过滤资源
	@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
	        initParams={
	                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
	      }
	)
	public class DruidStatFilter extends WebStatFilter implements Serializable{
	     private static final long serialVersionUID = 1L;
	}

	//配置访问路径，用户名，密码
	@WebServlet(urlPatterns = "/druid/*", 
		initParams={
		        @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
		        @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)
		        @WebInitParam(name="loginUsername",value="root"),// 用户名
		        @WebInitParam(name="loginPassword",value="root"),// 密码
		        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
		})
	public class DruidStatViewServlet extends StatViewServlet implements Serializable{
		private static final long serialVersionUID = 1L;
	}

swagger2 ： http://localhost:8080/swagger-ui.html 如图：

![](http://i.imgur.com/MkwOuR0.png)

![](http://i.imgur.com/8U2WVwG.png)


配置代码：

	//SwaggerConfig
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

添加jsp支持（spring boot 不推荐jsp做视图）

jsp配置，在属性配置文件中添加如下，或者隐式配置（在代码中编写）：

	#jsp视图设置
	spring.mvc.view.prefix=/WEB-INF/jsp/
	spring.mvc.view.suffix=.jsp

spring boot 支持servlet配置：

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